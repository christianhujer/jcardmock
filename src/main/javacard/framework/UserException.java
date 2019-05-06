package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class UserException extends CardException {
    public UserException(final short reason) {
        super(reason);
    }

    public UserException() {
        this((short) 0);
    }

    public static void throwIt(final short reason) throws UserException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(UserException.class, reason);
    }
}
