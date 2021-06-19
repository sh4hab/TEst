public class Header {

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
