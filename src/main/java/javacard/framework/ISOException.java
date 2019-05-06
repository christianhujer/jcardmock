package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class ISOException extends CardRuntimeException {
    public ISOException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws ISOException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(ISOException.class, reason);
    }
}
