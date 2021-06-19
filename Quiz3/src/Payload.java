public class Payload {
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
            }
        }
}
