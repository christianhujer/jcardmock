package javacard.security;

public interface RSAPublicKey extends PublicKey {
    short getExponent(byte[] buffer, short offset);
    short getModulus(byte[] buffer, short offset);
    void setExponent(byte[] buffer, short offset, short length);
    void setModulus(byte[] buffer, short offset, short length);
}
