package jcardmock.os;

import javacard.framework.CardRuntimeException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RuntimeEnvironmentOwnedExceptionInstances {
    private static Map<Class<? extends CardRuntimeException>, CardRuntimeException> runtimeEnvironmentOwnedExceptionInstances = new HashMap<>();
    public static void throwIt(final Class<? extends CardRuntimeException> cardRuntimeExceptionClass, final short reason) {
        final CardRuntimeException cardRuntimeException = runtimeEnvironmentOwnedExceptionInstances.computeIfAbsent(cardRuntimeExceptionClass, RuntimeEnvironmentOwnedExceptionInstances::throwNew);
        cardRuntimeException.setReason(reason);
        cardRuntimeException.fillInStackTrace();
        throw cardRuntimeException;
    }

    private static CardRuntimeException throwNew(final Class<? extends CardRuntimeException> aClass) {
        try {
            final Constructor<? extends CardRuntimeException> constructor = aClass.getConstructor(Short.TYPE);
            return constructor.newInstance((short) 0x0000);
        } catch (final NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
