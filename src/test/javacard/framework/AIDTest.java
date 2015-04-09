package javacard.framework;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.fill;
import static javacard.framework.Assert.assertByteEquals;
import static javacard.framework.Assert.assertShortEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AIDTest {

    @Test
    public void whenLengthLessThanFive_thenThrowsSystemException() {
        try {
            new AID(new byte[0], (short) 0, (byte) 4);
            fail("Expected SystemException");
        } catch (final SystemException e) {
            assertShortEquals(SystemException.ILLEGAL_VALUE, e.getReason());
        }
    }

    @Test
    public void whenLengthGreaterThanSixteen_thenThrowsSystemException() {
        try {
            new AID(new byte[0], (short) 0, (byte) 17);
            fail("Expected SystemException");
        } catch (final SystemException e) {
            assertShortEquals(SystemException.ILLEGAL_VALUE, e.getReason());
        }
    }

    @Test(expected = NullPointerException.class)
    public void whenBArrayIsNull_thenThrowsNullPointerException() {
        new AID(null, (short) 0, (byte) 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOffsetIsNegative_thenThrowsArrayIndexOutOfBoundsException() {
        new AID(new byte[5], (short) -1, (byte) 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenLengthIsNegative_thenThrowsArrayIndexOutOfBoundsException() {
        new AID(new byte[5], (short) 0, (byte) -1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOffsetPlusLengthIsGreaterThanArray_thenThrowsArrayIndexOutOfBoundsException() {
        new AID(new byte[5], (short) 1, (byte) 5);
    }

    @Test
    public void getBytes_returnsBytes() {
        final byte[] originalData = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        final AID aid = new AID(originalData, (short) 0, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] actualData = new byte[5];
        final byte length = aid.getBytes(actualData, (short) 0);
        assertByteEquals((byte) 5, length);
        final byte[] expectedData = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        assertTrue(Arrays.equals(expectedData, actualData));
    }

    @Test
    public void getBytesWithOffset_returnsBytes() {
        final byte[] originalData = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05 };
        final AID aid = new AID(originalData, (short) 1, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] actualData = new byte[6];
        final byte length = aid.getBytes(actualData, (short) 1);
        assertByteEquals((byte) 5, length);
        final byte[] expectedData = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05 };
        assertTrue(Arrays.equals(expectedData, actualData));
    }

    @Test
    public void testArrayEquals() {
        final byte[] originalData = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        final AID aid = new AID(originalData, (short) 1, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] comparisonData = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        assertTrue(aid.equals(comparisonData, (short) 1, (byte) 5));
    }

    @Test
    public void givenAidAndObject_whenEquals_thenReturnsFalse() {
        final Object o = new Object();
        final AID aid = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        assertFalse(aid.equals(o));
    }

    @Test
    public void givenTwoAidsWithDifferentData_whenEquals_thenReturnsFalse() {
        final AID aid1 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final AID aid2 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x06 }, (short) 0, (byte) 5);
        assertFalse(aid1.equals(aid2));
    }

    @Test
    public void givenTwoAidsWithSameData_whenEquals_thenReturnsTrue() {
        final AID aid1 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final AID aid2 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        assertTrue(aid1.equals(aid2));
    }

    @Test
    public void testGetPartialBytes() {
        final AID aid = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final byte[] buffer = new byte[5];
        // TODO
    }
}
