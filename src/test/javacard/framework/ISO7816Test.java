package javacard.framework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ISO7816Test {

    @Test
    public void testConstants() {
        assertByteEquals((byte) 0x00, ISO7816.CLA_ISO7816);
        assertByteEquals((byte) 0x82, ISO7816.INS_EXTERNAL_AUTHENTICATE);
        assertByteEquals((byte) 0xA4, ISO7816.INS_SELECT);
        assertByteEquals((byte) 5, ISO7816.OFFSET_CDATA);
        assertByteEquals((byte) 0, ISO7816.OFFSET_CLA);
        assertByteEquals((byte) 7, ISO7816.OFFSET_EXT_CDATA);
        assertByteEquals((byte) 1, ISO7816.OFFSET_INS);
        assertByteEquals((byte) 4, ISO7816.OFFSET_LC);
        assertByteEquals((byte) 2, ISO7816.OFFSET_P1);
        assertByteEquals((byte) 3, ISO7816.OFFSET_P2);
        assertShortEquals((short) 0x6999, ISO7816.SW_APPLET_SELECT_FAILED);
        assertShortEquals((short) 0x6100, ISO7816.SW_BYTES_REMAINING_00);
        assertShortEquals((short) 0x6E00, ISO7816.SW_CLA_NOT_SUPPORTED);
        assertShortEquals((short) 0x6884, ISO7816.SW_COMMAND_CHAINING_NOT_SUPPORTED);
        assertShortEquals((short) 0x6986, ISO7816.SW_COMMAND_NOT_ALLOWED);
        assertShortEquals((short) 0x6985, ISO7816.SW_CONDITIONS_NOT_SATISFIED);
        assertShortEquals((short) 0x6C00, ISO7816.SW_CORRECT_LENGTH_00);
        assertShortEquals((short) 0x6984, ISO7816.SW_DATA_INVALID);
        assertShortEquals((short) 0x6A84, ISO7816.SW_FILE_FULL);
        assertShortEquals((short) 0x6983, ISO7816.SW_FILE_INVALID);
        assertShortEquals((short) 0x6A82, ISO7816.SW_FILE_NOT_FOUND);
        assertShortEquals((short) 0x6A81, ISO7816.SW_FUNC_NOT_SUPPORTED);
        assertShortEquals((short) 0x6A86, ISO7816.SW_INCORRECT_P1P2);
        assertShortEquals((short) 0x6D00, ISO7816.SW_INS_NOT_SUPPORTED);
        assertShortEquals((short) 0x6883, ISO7816.SW_LAST_COMMAND_EXPECTED);
        assertShortEquals((short) 0x6881, ISO7816.SW_LOGICAL_CHANNEL_NOT_SUPPORTED);
        assertShortEquals((short) 0x9000, ISO7816.SW_NO_ERROR);
        assertShortEquals((short) 0x6A83, ISO7816.SW_RECORD_NOT_FOUND);
        assertShortEquals((short) 0x6882, ISO7816.SW_SECURE_MESSAGING_NOT_SUPPORTED);
        assertShortEquals((short) 0x6982, ISO7816.SW_SECURITY_STATUS_NOT_SATISFIED);
        assertShortEquals((short) 0x6F00, ISO7816.SW_UNKNOWN);
        assertShortEquals((short) 0x6200, ISO7816.SW_WARNING_STATE_UNCHANGED);
        assertShortEquals((short) 0x6A80, ISO7816.SW_WRONG_DATA);
        assertShortEquals((short) 0x6700, ISO7816.SW_WRONG_LENGTH);
        assertShortEquals((short) 0x6B00, ISO7816.SW_WRONG_P1P2);
    }

    private static void assertByteEquals(final byte expected, final byte actual) {
        assertEquals(expected, actual);
    }

    private static void assertShortEquals(final short expected, final short actual) {
        assertEquals(expected, actual);
    }
}
