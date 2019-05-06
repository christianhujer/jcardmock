package javacard.security;

public interface ECPrivateKey extends PrivateKey, ECKey {
    short getS(byte[] buffer, short offset);
    void setS(byte[] buffer, short offset, short length);
}
