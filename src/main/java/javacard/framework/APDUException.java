package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class APDUException extends CardRuntimeException {
    public static final short BAD_LENGTH = 3;
    public static final short BUFFER_BOUNDS = 2;
    public static final short ILLEGAL_USE = 1;
    public static final short IO_ERROR = 4;
    public static final short NO_T0_GETRESPONSE = 170;
    public static final short NO_T0_REISSUE = 172;
    public static final short T1_IFD_ABORT = 171;
    public APDUException(final short reason) {
        super(reason);
    }
    public static void throwIt(final short reason) throws APDUException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(APDUException.class, reason);
    }
}
