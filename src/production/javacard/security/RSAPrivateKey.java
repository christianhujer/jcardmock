package javacard.security;

public interface RSAPrivateKey extends PrivateKey {
    short getExponent(byte[] buffer, short offset);
    short getModulus(byte[] buffer, short offset);
    void setExponent(byte[] buffer, short offset, short length);
    void setModulus(byte[] buffer, short offset, short length);
}
