package javacard.framework;

import org.junit.Test;

import static javacard.framework.Assert.assertShortEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class CardExceptionTest {

    @Test
    public void whenNewException_thenStoresReason() {
        final CardException cardException = new CardException((short) 0x1234);
        assertReason((short) 0x1234, cardException);
    }

    @Test
    public void givenNewException_setReason_changesReason() {
        final CardException cardException = new CardException((short) 0x1234);
        cardException.setReason((short) 0x2345);
        assertReason((short) 0x2345, cardException);
    }

    @Test(expected = CardException.class)
    public void givenRuntimeOwnedInstance_whenThrowIt_thenThrowsException() throws CardException {
        CardException.throwIt((short) 0x1234);
    }

    @Test
    public void givenRuntimeOwnedInstance_whenThrowIt_thenStoresReason() {
        try {
            CardException.throwIt((short) 0x1234);
            fail();
        } catch (final CardException cardException) {
            assertReason((short) 0x1234, cardException);
        }
    }


    @Test
    public void givenThrownRuntimeOwnedInstance_setReason_changesReason() {
        try {
            CardException.throwIt((short) 0x1234);
            fail();
        } catch (final CardException cardException) {
            cardException.setReason((short) 0x2345);
            assertReason((short) 0x2345, cardException);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_changesReason() {
        try {
            CardException.throwIt((short) 0x1234);
            fail();
        } catch (final CardException cardException) {
            try {
                CardException.throwIt((short) 0x2345);
                fail();
            } catch (final CardException ignore) {}
            assertReason((short) 0x2345, cardException);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_bothAreSame() {
        try {
            CardException.throwIt((short) 0x1234);
            fail();
        } catch (final CardException firstCardException) {
            try {
                CardException.throwIt((short) 0x2345);
                fail();
            } catch (final CardException secondCardException) {
                assertSame(firstCardException, secondCardException);
            }
        }
    }

    public void assertReason(final short expectedReason, final CardException exception) {
        assertShortEquals(expectedReason, exception.getReason());
    }
}
