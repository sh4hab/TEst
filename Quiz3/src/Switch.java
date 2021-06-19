import java.util.Scanner;

public class Switch {

    private Parser parser;
    private Deparser deparser;
    private Scanner inputScanner;
    private Packet packet;
    private byte[] outputBuffer;
    private short outputPort;


    public Switch(){
        this.inputScanner = new Scanner(System.in);
        this.parser=new Parser(inputScanner);
        this.deparser = new Deparser();
    }

    public void run(){
        while(inputScanner.hasNext()){
            packet = parser.parse();
            packet.encode();
            outputPort = packet.forward();
            outputBuffer = deparser.deparse(packet);
            showOutputPacket(outputBuffer,outputPort);
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
