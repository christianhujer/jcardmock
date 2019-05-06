package jcardmock.os;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RuntimeEnvironmentOwnedExceptionInstances {
    private static Map<Class<? extends Exception>, Exception> runtimeEnvironmentOwnedExceptionInstances = new HashMap<>();
    public static <E extends Exception> void throwIt(final Class<E> exceptionClass, final short reason) throws E {
        final E exception = (E) runtimeEnvironmentOwnedExceptionInstances.computeIfAbsent(exceptionClass, RuntimeEnvironmentOwnedExceptionInstances::createNew);
        setReason(exception, reason);
        exception.fillInStackTrace();
        throw exception;
    }

    private static void setReason(final Exception exception, final short reason) {
        try {
            final Method setReason = exception.getClass().getMethod("setReason", Short.TYPE);
            setReason.invoke(exception, reason);
        } catch (final InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    private static Exception createNew(final Class<? extends Exception> aClass) {
        try {
            final Constructor<? extends Exception> constructor = aClass.getConstructor(Short.TYPE);
            return constructor.newInstance((short) 0x0000);
        } catch (final NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
