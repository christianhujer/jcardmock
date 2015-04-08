package javacard.security;

public interface DSAPublicKey extends PublicKey, DSAKey {
    short getY(byte[] buffer, short offset);
    void setY(byte[] buffer, short offset, short length);
}
