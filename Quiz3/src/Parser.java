import java.util.Scanner;

public class Parser {
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
        byte srcAddress = inputScanner.nextByte(2) ;
        byte destAddress = inputScanner.nextByte(2);
        byte payloadLength =inputScanner.nextByte(2);
        byte key =inputScanner.nextByte(2);
        return new Header(srcAddress , destAddress,payloadLength ,key) ;
    }

    public Payload parsePayload(Scanner inputScanner, byte payloadLength){
        byte temp = 0x00 ;
        byte [] payloadBytes = new byte[payloadLength];
        while (temp < payloadLength){
            payloadBytes[temp] = inputScanner.nextByte(2);
            temp ++ ;
        }
        return new Payload(payloadLength , payloadBytes);
    }
}
