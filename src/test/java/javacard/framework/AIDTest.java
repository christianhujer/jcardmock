package javacard.framework;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.fill;
import static javacard.framework.Assert.assertByteEquals;
import static javacard.framework.Assert.assertShortEquals;
import static org.junit.jupiter.api.Assertions.*;

class AIDTest {

    @Test
    void whenLengthLessThanFive_thenThrowsSystemException() {
        try {
            new AID(new byte[0], (short) 0, (byte) 4);
            fail("Expected SystemException");
        } catch (final SystemException e) {
            assertShortEquals(SystemException.ILLEGAL_VALUE, e.getReason());
        }
    }

    @Test
    void whenLengthGreaterThanSixteen_thenThrowsSystemException() {
        try {
            new AID(new byte[0], (short) 0, (byte) 17);
            fail("Expected SystemException");
        } catch (final SystemException e) {
            assertShortEquals(SystemException.ILLEGAL_VALUE, e.getReason());
        }
    }

    @Test
    void whenBArrayIsNull_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AID(null, (short) 0, (byte) 5));
    }

    @Test
    void whenOffsetIsNegative_thenThrowsArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new AID(new byte[5], (short) -1, (byte) 5));
    }

    @Test
    void whenLengthIsNegative_thenThrowsArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new AID(new byte[5], (short) 0, (byte) -1));
    }

    @Test
    void whenOffsetPlusLengthIsGreaterThanArray_thenThrowsArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new AID(new byte[5], (short) 1, (byte) 5));
    }

    @Test
    void getBytes_returnsBytes() {
        final byte[] originalData = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        final AID aid = new AID(originalData, (short) 0, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] actualData = new byte[5];
        final byte length = aid.getBytes(actualData, (short) 0);
        assertByteEquals((byte) 5, length);
        final byte[] expectedData = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    void getBytesWithOffset_returnsBytes() {
        final byte[] originalData = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05 };
        final AID aid = new AID(originalData, (short) 1, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] actualData = new byte[6];
        final byte length = aid.getBytes(actualData, (short) 1);
        assertByteEquals((byte) 5, length);
        final byte[] expectedData = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05 };
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    void testArrayEquals() {
        final byte[] originalData = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        final AID aid = new AID(originalData, (short) 1, (byte) 5);
        fill(originalData, (byte) 0);
        final byte[] comparisonData = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        assertTrue(aid.equals(comparisonData, (short) 1, (byte) 5));
    }

    @Test
    void givenAidAndObject_whenEquals_thenReturnsFalse() {
        final Object o = new Object();
        final AID aid = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        assertNotEquals(aid, o);
    }

    @Test
    void givenTwoAidsWithDifferentData_whenEquals_thenReturnsFalse() {
        final AID aid1 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final AID aid2 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x06 }, (short) 0, (byte) 5);
        assertNotEquals(aid1, aid2);
    }

    @Test
    void givenTwoAidsWithSameData_whenEquals_thenReturnsTrue() {
        final AID aid1 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final AID aid2 = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        assertEquals(aid1, aid2);
    }

    @Test
    void testGetPartialBytes() {
        final AID aid = new AID(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 }, (short) 0, (byte) 5);
        final byte[] buffer = new byte[5];
        // TODO
    }
}
