package javacard.security;

public interface SignatureMessageRecovery {
    short beginVerify(byte[] sigAndRecDataBuff, short buffOffset, short sigLength);
    byte getAlgorithm();
    short getLength();
    void init(Key theKey, byte theMode);
    short sign(byte[] inBuff, short inOffset, short inLength, byte[] sigBuff, short sigOffset, short[] recMsgLen, short recMsgLenOffset);
    void update(byte[] inBuff, short inOffset, short inLength);
    boolean verify(byte[] inBuff, short inOffset, short inLength);
}
