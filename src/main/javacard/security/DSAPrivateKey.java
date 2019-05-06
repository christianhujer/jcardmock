package javacard.security;

public interface DSAPrivateKey extends PrivateKey, DSAKey {
    short getX(byte[] buffer, short offset);
    void setX(byte[] buffer, short offset, short length);
}
