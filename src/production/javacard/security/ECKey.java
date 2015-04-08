package javacard.security;

public interface ECKey {
    short getA(byte[] buffer, short offset);
    short getB(byte[] buffer, short offset);
    short getField(byte[] buffer, short offset);
    short getG(byte[] buffer, short offset);
    short getK();
    short getR(byte[] buffer, short offset);
    void setA(byte[] buffer, short offset, short length);
    void setB(byte[] buffer, short offset, short length);
    void setFieldF2M(short e);
    void setFieldF2M(short e1, short e2, short e3);
    void setFieldFP(byte[] buffer, short offset, short length);
    void setG(byte[] buffer, short offset, short length);
    void setK(short K);
    void setR(byte[] buffer, short offset, short length);
}
