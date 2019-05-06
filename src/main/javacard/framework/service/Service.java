package javacard.framework.service;

import javacard.framework.APDU;

public interface Service {
    boolean processCommand(APDU apdu);
    boolean processDataIn(APDU apdu);
    boolean processDataOut(APDU apdu);
}
