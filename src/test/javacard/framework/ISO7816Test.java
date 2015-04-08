package javacard.framework;

import org.junit.Test;

import static javacard.framework.Assert.assertByteEquals;
import static javacard.framework.Assert.assertShortEquals;
import static javacard.framework.ISO7816.*;

public class ISO7816Test {

    @Test
    public void testConstants() {
        assertByteEquals((byte) 0x00, CLA_ISO7816);
        assertByteEquals((byte) 0x82, INS_EXTERNAL_AUTHENTICATE);
        assertByteEquals((byte) 0xA4, INS_SELECT);
        assertByteEquals((byte) 5, OFFSET_CDATA);
        assertByteEquals((byte) 0, OFFSET_CLA);
        assertByteEquals((byte) 7, OFFSET_EXT_CDATA);
        assertByteEquals((byte) 1, OFFSET_INS);
        assertByteEquals((byte) 4, OFFSET_LC);
        assertByteEquals((byte) 2, OFFSET_P1);
        assertByteEquals((byte) 3, OFFSET_P2);
        assertShortEquals((short) 0x6999, SW_APPLET_SELECT_FAILED);
        assertShortEquals((short) 0x6100, SW_BYTES_REMAINING_00);
        assertShortEquals((short) 0x6E00, SW_CLA_NOT_SUPPORTED);
        assertShortEquals((short) 0x6884, SW_COMMAND_CHAINING_NOT_SUPPORTED);
        assertShortEquals((short) 0x6986, SW_COMMAND_NOT_ALLOWED);
        assertShortEquals((short) 0x6985, SW_CONDITIONS_NOT_SATISFIED);
        assertShortEquals((short) 0x6C00, SW_CORRECT_LENGTH_00);
        assertShortEquals((short) 0x6984, SW_DATA_INVALID);
        assertShortEquals((short) 0x6A84, SW_FILE_FULL);
        assertShortEquals((short) 0x6983, SW_FILE_INVALID);
        assertShortEquals((short) 0x6A82, SW_FILE_NOT_FOUND);
        assertShortEquals((short) 0x6A81, SW_FUNC_NOT_SUPPORTED);
        assertShortEquals((short) 0x6A86, SW_INCORRECT_P1P2);
        assertShortEquals((short) 0x6D00, SW_INS_NOT_SUPPORTED);
        assertShortEquals((short) 0x6883, SW_LAST_COMMAND_EXPECTED);
        assertShortEquals((short) 0x6881, SW_LOGICAL_CHANNEL_NOT_SUPPORTED);
        assertShortEquals((short) 0x9000, SW_NO_ERROR);
        assertShortEquals((short) 0x6A83, SW_RECORD_NOT_FOUND);
        assertShortEquals((short) 0x6882, SW_SECURE_MESSAGING_NOT_SUPPORTED);
        assertShortEquals((short) 0x6982, SW_SECURITY_STATUS_NOT_SATISFIED);
        assertShortEquals((short) 0x6F00, SW_UNKNOWN);
        assertShortEquals((short) 0x6200, SW_WARNING_STATE_UNCHANGED);
        assertShortEquals((short) 0x6A80, SW_WRONG_DATA);
        assertShortEquals((short) 0x6700, SW_WRONG_LENGTH);
        assertShortEquals((short) 0x6B00, SW_WRONG_P1P2);
    }

}
