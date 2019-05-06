package javacard.security;

public interface AESKey extends SecretKey {
    byte getKey(byte[] keyData, short kOff);
    void setKey(byte[] keyData, short kOff);
}
