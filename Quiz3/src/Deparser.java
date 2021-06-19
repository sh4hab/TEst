public class Deparser {

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
