package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class SystemException extends CardRuntimeException {
    public static final short ILLEGAL_AID = 4;
    public static final short ILLEGAL_TRANSIENT = 3;
    public static final short ILLEGAL_USE = 6;
    public static final short ILLEGAL_VALUE = 1;
    public static final short NO_RESOURCE = 5;
    public static final short NO_TRANSIENT_SPACE = 2;

    public SystemException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws SystemException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(SystemException.class, reason);
    }
}
