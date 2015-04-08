package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class PINException extends CardRuntimeException {
    public static final short ILLEGAL_VALUE = 1;
    public PINException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws PINException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(PINException.class, reason);
    }
}
