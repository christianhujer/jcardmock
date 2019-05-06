package javacard.security;

import javacard.framework.AbstractCardExceptionTest;
import org.junit.jupiter.api.Test;

import static javacard.framework.Assert.assertShortEquals;
import static javacard.security.CryptoException.*;

public class CryptoExceptionTest extends AbstractCardExceptionTest<CryptoException> {
    public CryptoExceptionTest() {
        super(CryptoException.class);
    }

    @Test
    public void testConstants() {
        assertShortEquals((short) 5, ILLEGAL_USE);
        assertShortEquals((short) 1, ILLEGAL_VALUE);
        assertShortEquals((short) 4, INVALID_INIT);
        assertShortEquals((short) 3, NO_SUCH_ALGORITHM);
        assertShortEquals((short) 2, UNINITIALIZED_KEY);
    }
}
