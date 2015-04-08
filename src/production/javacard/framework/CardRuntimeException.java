package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class CardRuntimeException extends RuntimeException {
    private short reason;
    public CardRuntimeException(final short reason) {
        this.reason = reason;
    }

    public void setReason(final short reason) {
        this.reason = reason;
    }

    public static void throwIt(final short reason) throws CardRuntimeException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(CardRuntimeException.class, reason);
    }

    public short getReason() {
        return reason;
    }
}
