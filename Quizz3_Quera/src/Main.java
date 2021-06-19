import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Switch mySwitch = new Switch();
        mySwitch.run();
    }
}
class Payload {
    private byte length;
    private String context;
    private byte[] payloadBytes ;

    public Payload(byte length, byte[] payloadBytes) {
        this.length = length;
        this.payloadBytes = payloadBytes ;
        this.context = new String(payloadBytes);
    }

    public byte getPayloadBytes(int i) {
        return payloadBytes[i];
    }

    public String toString(){
        int i ;
        String payloadWord = "";
        for (i = 0 ;i < this.length ; i++){
            payloadWord = payloadWord + (char)payloadBytes[i];
        }
        return payloadWord.toLowerCase(Locale.ROOT) ;
    }

    public String getContext() {
        return context;
    }

    public byte getLength() {
        return length;
    }

    public void encode(byte key) {
        int temp = 0 ;
        while (temp < this.length){
            payloadBytes[temp] = (byte) (payloadBytes[temp] + key);
            temp++ ;
        }
    }
}
class Header {

    private byte srcAddress;
    private byte dstAddress;
    private byte payloadLength;
    private byte key;

    public Header(byte srcAddress, byte dstAddress, byte payloadLength, byte key){
        this.srcAddress=srcAddress;
        this.dstAddress=dstAddress;
        this.payloadLength=payloadLength;
        this.key = key;
    }


    public byte getPayloadLength() {
        return payloadLength;
    }
    public byte getSrcAddress(){
        return srcAddress;
    }

    public byte getKey() {
        return key;
    }

    public byte getDstAddress() {
        return dstAddress;
    }
}
class Packet {
    private Header header;
    private Payload payload;
    public Packet(Header header, Payload payload){
        this.header=header;
        this.payload=payload;
    }

    public short forward(){
        if (header.getDstAddress() == 110 || header.getDstAddress() == 120)
            return 1 ;
        else if (header.getDstAddress() == 50 || header.getDstAddress() == 60 )
            return 2 ;
        else if (header.getDstAddress() == 100 || header.getDstAddress() == 90)
            return 3 ;
        else if (header.getDstAddress() == 70 || header.getDstAddress() == 80)
            return 4 ;
        else
            return 0 ;
    }
    public void encode(){
        payload.encode(header.getKey());
    }

    public Header getHeader() {
        return header;
    }

    public Payload getPayload() {
        return payload;
    }
}


class Parser {
    static final int HEADER_LENGTH = 4;
    private Scanner inputScanner;
    private byte[] headerBuffer;


    public Parser(Scanner scanner){
        inputScanner = scanner;
        headerBuffer = new byte[HEADER_LENGTH];
    }

    public Packet parse(){
        Header header = parseHeader(this.inputScanner);
        Payload payload = parsePayload(this.inputScanner,header.getPayloadLength());
        return new Packet(header,payload);
    }

    public Header parseHeader(Scanner inputScanner){
        byte srcAddress =  inputScanner.nextByte(2) ;
        byte destAddress = inputScanner.nextByte(2);
        byte payloadLength =inputScanner.nextByte(2);
        byte key =inputScanner.nextByte(2);
        return new Header(srcAddress , destAddress,payloadLength ,key) ;
    }

    public Payload parsePayload(Scanner inputScanner, byte payloadLength){
        int temp = 0 ;
        byte [] payloadBytes = new byte[Byte.toUnsignedInt(payloadLength)];
       for (temp = 0 ; temp < Byte.toUnsignedInt(payloadLength) ; temp ++){
            payloadBytes[temp] = inputScanner.nextByte(2);
        }
        return new Payload(payloadLength , payloadBytes);
    }
}
class Deparser {

    public byte[] deparse(Packet packet){
        byte[] headerBytes = deparseHeader(packet.getHeader());
        byte[] payloadBytes = deparsePayload(packet.getPayload());
        byte[] output = new byte[headerBytes.length + payloadBytes.length];
        System.arraycopy(headerBytes, 0, output, 0, headerBytes.length);
        System.arraycopy(payloadBytes, 0, output, headerBytes.length, payloadBytes.length);
        return output;
    }
    public byte[] deparseHeader(Header header){
        byte [] headerBytes = new byte[4];
        headerBytes[0] = header.getSrcAddress();
        headerBytes[1] = header.getDstAddress();
        headerBytes[2] = header.getPayloadLength();
        headerBytes[3] = 0x00 ;
        return headerBytes ;
    }
    public byte[] deparsePayload(Payload payload){
        byte [] payloadBytes = new byte[payload.getLength()];
        int i ;
        for (i = 0 ; i < payload.getLength() ;i++){
            payloadBytes[i] = payload.getPayloadBytes(i);
        }
        return payloadBytes;
    }
}

class Switch {

    private Parser parser;
    private Deparser deparser;
    private Scanner inputScanner;
    private Packet packet;
    private byte[] outputBuffer;
    private short outputPort;
    private ArrayList<String> filterWords = new ArrayList<>();

    public void setFilterWords(){
        filterWords.add("yellow");
        filterWords.add("Karma");
        filterWords.add("Hooman");
        filterWords.add("Tehran");
        filterWords.add("gun");
        filterWords.add("sadness");
        filterWords.add("Pride");
        filterWords.add("language");
        filterWords.add("Laptop");
        filterWords.add("stalker");
    }

    public Switch(){
        this.inputScanner = new Scanner(System.in);
        this.parser=new Parser(inputScanner);
        this.deparser = new Deparser();
    }
    public boolean isFiltered() {
        for (String filterWord : filterWords) {
            if (packet.getPayload().toString().contains(filterWord.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false ;
    }
    public void run(){
        while(inputScanner.hasNext()){
            packet = parser.parse();
            this.setFilterWords();
            if (isFiltered()){
                outputPort = 0x00 ;
            }else {
                outputPort = packet.forward() ;
                packet.encode();
            }
            outputBuffer = deparser.deparse(packet);
            showOutputPacket(outputBuffer, outputPort);
        }
    }


    private String toBitString(final byte[] b) {
        final char[] bits = new char[8 * b.length];
        for(int i = 0; i < b.length; i++) {
            final byte byteval = b[i];
            int bytei = i << 3;
            int mask = 0x1;
            for(int j = 7; j >= 0; j--) {
                final int bitval = byteval & mask;
                if(bitval == 0) {
                    bits[bytei + j] = '0';
                } else {
                    bits[bytei + j] = '1';
                }
                mask <<= 1;
            }
        }
        return String.valueOf(bits);
    }
    private void showOutputPacket(byte[] outputBuffer, short outputPort){
        System.out.println(outputPort + ": " + toBitString(outputBuffer));
    }
}
