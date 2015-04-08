package javacard.framework;

import jcardmock.os.RuntimeEnvironmentOwnedExceptionInstances;

public class CardException extends Exception {
    private short reason;

    public CardException(final short reason) {
        this.reason = reason;
    }

    public void setReason(final short reason) {
        this.reason = reason;
    }

    public static void throwIt(final short reason) throws CardException {
        RuntimeEnvironmentOwnedExceptionInstances.throwIt(CardException.class, reason);
    }

    public short getReason() {
        return reason;
    }
}
