package javacard.framework;

public interface PIN {
    boolean check(byte[] pin, short offset, byte length);
    byte getTriesRemaining();
    boolean isValidated();
    void reset();
}
