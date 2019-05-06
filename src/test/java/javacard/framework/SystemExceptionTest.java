package javacard.framework;

import org.junit.jupiter.api.Test;

import static javacard.framework.Assert.assertShortEquals;
import static javacard.framework.SystemException.*;

public class SystemExceptionTest extends AbstractCardExceptionTest<SystemException> {
    public SystemExceptionTest() {
        super(SystemException.class);
    }

    @Test
    public void testConstants() {
        assertShortEquals((short) 4, ILLEGAL_AID);
        assertShortEquals((short) 3, ILLEGAL_TRANSIENT);
        assertShortEquals((short) 6, ILLEGAL_USE);
        assertShortEquals((short) 1, ILLEGAL_VALUE);
        assertShortEquals((short) 5, NO_RESOURCE);
        assertShortEquals((short) 2, NO_TRANSIENT_SPACE);
    }
}
