package javacard.security;

public interface DSAKey {
    short getG(byte[] buffer, short offset);
    short getP(byte[] buffer, short offset);
    short getQ(byte[] buffer, short offset);
    void setG(byte[] buffer, short offset, short length);
    void setP(byte[] buffer, short offset, short length);
    void setQ(byte[] buffer, short offset, short length);
}
