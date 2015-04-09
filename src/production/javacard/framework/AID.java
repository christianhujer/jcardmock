package javacard.framework;

import java.util.Arrays;

public class AID {
    private final byte[] aidBytes;
    public AID(final byte[] bArray, final short offset, final byte length) {
        if (length < 0) throw new ArrayIndexOutOfBoundsException();
        if (length < 5) SystemException.throwIt(SystemException.ILLEGAL_VALUE);
        if (length > 16) SystemException.throwIt(SystemException.ILLEGAL_VALUE);
        aidBytes = new byte[length];
        System.arraycopy(bArray, offset, aidBytes, 0, length);
    }

    public void getBytes(final byte[] dest, final short offset) {
        System.arraycopy(aidBytes, 0, dest, offset, aidBytes.length);
    }

    public boolean equals(final byte[] bArray, final short offset, final byte length) {
        if (length != aidBytes.length) return false;
        for (short i = 0; i < length; i++)
            if (bArray[offset + i] != aidBytes[i]) return false;
        return true;
    }

    public boolean equals(final Object anObject) {
        if (!(anObject instanceof AID)) return false;
        final AID other = (AID) anObject;
        return Arrays.equals(aidBytes, other.aidBytes);
    }
}
