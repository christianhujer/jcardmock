package javacard.framework;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javacard.framework.Assert.assertShortEquals;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
public abstract class AbstractCardExceptionTest<E extends Exception> {

    private final Class<E> exceptionClass;

    protected AbstractCardExceptionTest(final Class<E> exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    protected E createException(final short reason) {
        try {
            final Constructor<E> constructor = exceptionClass.getConstructor(Short.TYPE);
            return constructor.newInstance(reason);
        } catch (final InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new AssertionError(e);
        }
    }

    @Test
    public void whenNewException_thenStoresReason() {
        final E exception = createException((short) 0x1234);
        assertReason((short) 0x1234, exception);
    }

    @Test
    public void givenNewException_setReason_changesReason() {
        final E exception = createException((short) 0x1234);
        setReason(exception, (short) 0x2345);
        assertReason((short) 0x2345, exception);
    }

    @Test
    public void givenRuntimeOwnedInstance_whenThrowIt_thenThrowsException() throws E {
        try {
            throwIt((short) 0x1234);
            fail("Expected " + exceptionClass + " to be thrown.");
        } catch (final Exception e) {
            assertTrue(exceptionClass.isInstance(e));
        }
    }

    @Test
    public void givenRuntimeOwnedInstance_whenThrowIt_thenStoresReason() {
        try {
            throwIt((short) 0x1234);
            fail();
        } catch (final Exception e) {
            assertReason((short) 0x1234, (E) e);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_setReason_changesReason() {
        try {
            throwIt((short) 0x1234);
            fail();
        } catch (final Exception e) {
            setReason((E) e, (short) 0x2345);
            assertReason((short) 0x2345, (E) e);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_changesReason() {
        try {
            throwIt((short) 0x1234);
            fail();
        } catch (final Exception e) {
            try {
                throwIt((short) 0x2345);
                fail();
            } catch (final Exception ignore) {}
            assertReason((short) 0x2345, (E) e);
        }
    }

    @Test
    public void givenThrownRuntimeOwnedInstance_throwIt_bothAreSame() {
        try {
            throwIt((short) 0x1234);
            fail();
        } catch (final Exception firstException) {
            try {
                throwIt((short) 0x2345);
                fail();
            } catch (final Exception secondException) {
                assertSame(firstException, secondException);
            }
        }
    }

    private short getReason(final E exception) {
        try {
            final Method getReason = exception.getClass().getMethod("getReason");
            return (short) getReason.invoke(exception);
        } catch (final InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    private void setReason(final E exception, final short reason) {
        try {
            final Method setReason = exception.getClass().getMethod("setReason", Short.TYPE);
            setReason.invoke(exception, reason);
        } catch (final InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    private void throwIt(final short reason) throws E {
        try {
            final Method throwIt = exceptionClass.getDeclaredMethod("throwIt", Short.TYPE);
            throwIt.invoke(null, reason);
        } catch (final InvocationTargetException e) {
            final Throwable cause = e.getCause();
            if (exceptionClass.isInstance(cause))
                throw (E) cause;
            throw new AssertionError(e);
        } catch (final NoSuchMethodException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    public void assertReason(final short expectedReason, final E exception) {
        assertShortEquals(expectedReason, getReason(exception));
    }
}
