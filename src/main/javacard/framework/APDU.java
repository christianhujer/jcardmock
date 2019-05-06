package javacard.framework;

public class APDU {
    public static final byte PROTOCOL_MEDIA_CONTACTLESS_TYPE_A = -128;
    public static final byte PROTOCOL_MEDIA_CONTACTLESS_TYPE_B = -112;
    public static final byte PROTOCOL_MEDIA_CONTACTLESS_TYPE_F = -80;
    public static final byte PROTOCOL_MEDIA_DEFAULT = 0;
    public static final byte PROTOCOL_MEDIA_HCI_APDU_GATE = -80;
    public static final byte PROTOCOL_MEDIA_MASK = -16;
    public static final byte PROTOCOL_MEDIA_USB = -96;
    public static final byte PROTOCOL_T0 = 0;
    public static final byte PROTOCOL_T1 = 1;
    public static final byte PROTOCOL_TYPE_MASK = 15;
    public static final byte STATE_ERROR_IO = -3;
    public static final byte STATE_ERROR_NO_T0_GETRESPONSE = -1;
    public static final byte STATE_ERROR_NO_T0_REISSUE = -4;
    public static final byte STATE_ERROR_T1_IFD_ABORT = -2;
    public static final byte STATE_FULL_INCOMING = 2;
    public static final byte STATE_FULL_OUTGOING = 6;
    public static final byte STATE_INITIAL = 0;
    public static final byte STATE_OUTGOING = 3;
    public static final byte STATE_OUTGOING_LENGTH_KNOWN = 4;
    public static final byte STATE_PARTIAL_INCOMING = 1;
    public static final byte STATE_PARTIAL_OUTGOING = 5;

    // TODO support multiple interfaces
    private static final APDU INSTANCE = new APDU();

    private final byte[] buffer = new byte[261];
    public byte[] getBuffer() {
        return buffer;
    }
    public static short getInBlockSize() {
        return 1; // TODO: Support T=1 and Contactless
    }
    public static short getOutBlockSize() {
        return 258; // TODO: Support T=1 and Contactless
    }
    public static byte getProtocol() {
        return PROTOCOL_T0; // TODO: Support T=1 and Contactless (also returns T=1)
    }
    public byte getNAD() {
        return 0; // TODO: Supor T=1
    }
    public short setOutgoing() throws APDUException, ISOException {
        return 0; // TODO return actual Ne
    }
    public short setOutgoingNoChaining() throws APDUException, ISOException {
        return 0; // TODO return actual Ne
    }
    public void setOutgoingLength(final short le) throws APDUException {
        // TODO in T=0 simulate sending the GET RESPONSE command
    }
    public short receiveBytes(short bOff) throws APDUException {
        // TODO
        return 0;
    }
    public short setIncomingAndReceive() throws APDUException {
        // TODO
        return 0;
    }
    public void sendBytes(short bOff, short len) throws APDUException {
        // TODO
    }
    public void sendBytesLong(byte[] outData, short bOff, short len) throws APDUException, SecurityException {
        // TODO
    }
    public void setOutgoingAndSend(short bOff, short len) throws APDUException {
        // TODO
    }
    public byte getCurrentState() {
        // TODO Implement state machine
        return STATE_INITIAL;
    }
    public static APDU getCurrentAPDU() {
        return INSTANCE;
    }
    public static byte[] getCurrentAPDUBuffer() {
        return INSTANCE.buffer;
    }
    public static byte getCLAChannel() {
        // TODO Implement
        return 0;
    }
    public static void waitExtension() throws APDUException {
        // TODO send MORE TIME
    }
    public boolean isCommandChainingCLA() {
        // TODO Implement command chaining
        return false;
    }
    public boolean isSecureMessagingCLA() {
        // TODO Implement Secure Messaging
        return false;
    }
    public boolean isISOInterindustryCLA() {
        // TODO Implement ISO Interindustry
        return false;
    }
    public boolean isValidCLA() {
        // TODO Implement
        return true;
    }
    public short getIncomingLength() throws APDUException {
        // TODO Implement
        return 0;
    }
    public short getOffsetCdata() {
        // TODO Implement
        return 0;
    }
}
