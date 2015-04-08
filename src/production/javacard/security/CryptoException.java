package javacard.security;

import javacard.framework.CardRuntimeException;
import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class CryptoException extends CardRuntimeException {
    public static final short ILLEGAL_USE = 5;
    public static final short ILLEGAL_VALUE = 1;
    public static final short INVALID_INIT = 4;
    public static final short NO_SUCH_ALGORITHM = 3;
    public static final short UNINITIALIZED_KEY = 2;
    public CryptoException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws CryptoException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(CryptoException.class, reason);
    }
}
