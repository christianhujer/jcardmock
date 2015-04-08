package javacard.framework;

import org.junit.Test;

import static javacard.framework.Assert.assertShortEquals;

public class PINExceptionTest extends AbstractCardExceptionTest<PINException> {
    public PINExceptionTest() {
        super(PINException.class);
    }

    @Test
    public void testConstants() {
        assertShortEquals((short) 1, PINException.ILLEGAL_VALUE);
    }
}
