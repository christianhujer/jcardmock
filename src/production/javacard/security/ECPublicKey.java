package javacard.security;

public interface ECPublicKey extends PublicKey, ECKey {
    short getW(byte[] buffer, short offset);
    void setW(byte[] buffer, short offset, short length);
}
