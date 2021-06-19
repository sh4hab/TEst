public class Packet {
    private Header header;
    private Payload payload;

    public Packet(Header header, Payload payload){
        this.header=header;
        this.payload=payload;
    }

    public short forward(){
        return header.getDstAddress();
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
