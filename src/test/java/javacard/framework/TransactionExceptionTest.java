package javacard.framework;

import org.junit.jupiter.api.Test;

import static javacard.framework.Assert.assertShortEquals;
import static javacard.framework.TransactionException.*;

public class TransactionExceptionTest extends AbstractCardExceptionTest<TransactionException> {
    public TransactionExceptionTest() {
        super(TransactionException.class);
    }

    @Test
    public void testConstants() {
        assertShortEquals((short) 3, BUFFER_FULL);
        assertShortEquals((short) 5, ILLEGAL_USE);
        assertShortEquals((short) 1, IN_PROGRESS);
        assertShortEquals((short) 4, INTERNAL_FAILURE);
        assertShortEquals((short) 2, NOT_IN_PROGRESS);
    }
}
