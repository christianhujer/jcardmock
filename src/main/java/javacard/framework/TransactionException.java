package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class TransactionException extends CardRuntimeException {
    public static final short BUFFER_FULL = 3;
    public static final short ILLEGAL_USE = 5;
    public static final short IN_PROGRESS = 1;
    public static final short INTERNAL_FAILURE = 4;
    public static final short NOT_IN_PROGRESS = 2;
    public TransactionException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws TransactionException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(TransactionException.class, reason);
    }
}
