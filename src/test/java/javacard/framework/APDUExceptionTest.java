package javacard.framework;

import org.junit.jupiter.api.Test;

import static javacard.framework.APDUException.*;
import static javacard.framework.Assert.assertShortEquals;

class APDUExceptionTest extends AbstractCardExceptionTest<APDUException> {
    APDUExceptionTest() {
        super(APDUException.class);
    }

    @Test
    void testConstants() {
        assertShortEquals((short) 3, BAD_LENGTH);
        assertShortEquals((short) 2, BUFFER_BOUNDS);
        assertShortEquals((short) 1, ILLEGAL_USE);
        assertShortEquals((short) 4, IO_ERROR);
        assertShortEquals((short) 170, NO_T0_GETRESPONSE);
        assertShortEquals((short) 172, NO_T0_REISSUE);
        assertShortEquals((short) 171, T1_IFD_ABORT);
    }
}
