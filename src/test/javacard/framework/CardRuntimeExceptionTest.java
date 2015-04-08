package javacard.framework;

import org.junit.Test;

import static javacard.framework.Assert.assertShortEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class CardRuntimeExceptionTest {

    @Test
    public void whenNewException_thenStoresReason() {
        final CardRuntimeException cardRuntimeException = new CardRuntimeException((short) 0x1234);
        assertReason((short) 0x1234, cardRuntimeException);
    }

    @Test
    public void givenNewException_setReason_changesReason() {
        final CardRuntimeException cardRuntimeException = new CardRuntimeException((short) 0x1234);
        cardRuntimeException.setReason((short) 0x2345);
        assertReason((short) 0x2345, cardRuntimeException);
    }

    @Test(expected = CardRuntimeException.class)
    public void givenRuntimeOwnedInstance_whenThrowIt_thenThrowsException() {
        CardRuntimeException.throwIt((short) 0x1234);
    }

    @Test
    public void givenRuntimeOwnedInstance_whenThrowIt_thenStoresReason() {
        try {
            CardRuntimeException.throwIt((short) 0x1234);
            fail();
        } catch (final CardRuntimeException cardRuntimeException) {
            assertReason((short) 0x1234, cardRuntimeException);
        }
    }


    @Test
    public void givenThrownRuntimeOwnedInstance_setReason_changesReason() {
        try {
            CardRuntimeException.throwIt((short) 0x1234);
            fail();
        } catch (final CardRuntimeException cardRuntimeException) {
            cardRuntimeException.setReason((short) 0x2345);
            assertReason((short) 0x2345, cardRuntimeException);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_changesReason() {
        try {
            CardRuntimeException.throwIt((short) 0x1234);
            fail();
        } catch (final CardRuntimeException cardRuntimeException) {
            try {
                CardRuntimeException.throwIt((short) 0x2345);
                fail();
            } catch (final CardRuntimeException ignore) {}
            assertReason((short) 0x2345, cardRuntimeException);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_bothAreSame() {
        try {
            CardRuntimeException.throwIt((short) 0x1234);
            fail();
        } catch (final CardRuntimeException firstCardRuntimeException) {
            try {
                CardRuntimeException.throwIt((short) 0x2345);
                fail();
            } catch (final CardRuntimeException secondCardRuntimeException) {
                assertSame(firstCardRuntimeException, secondCardRuntimeException);
            }
        }
    }

    public void assertReason(final short expectedReason, final CardRuntimeException exception) {
        assertShortEquals(expectedReason, exception.getReason());
    }
}
