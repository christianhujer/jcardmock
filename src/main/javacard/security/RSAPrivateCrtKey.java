package javacard.security;

public interface RSAPrivateCrtKey extends PrivateKey {
    short getDP1(byte[] buffer, short offset);
    short getDQ1(byte[] buffer, short offset);
    short getP(byte[] buffer, short offset);
    short getPQ(byte[] buffer, short offset);
    short getQ(byte[] buffer, short offset);
    void setDP1(byte[] buffer, short offset, short length);
    void setDQ1(byte[] buffer, short offset, short length);
    void setP(byte[] buffer, short offset, short length);
    void setPQ(byte[] buffer, short offset, short length);
    void setQ(byte[] buffer, short offset, short length);
}
