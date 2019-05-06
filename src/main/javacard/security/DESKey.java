package javacard.security;

public interface DESKey {
    byte getKey(byte[] keyData, short kOff);
    void setKey(byte[] keyData, short kOff);
}
