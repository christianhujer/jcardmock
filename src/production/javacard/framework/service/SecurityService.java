package javacard.framework.service;

public interface SecurityService {
    short PRINCIPAL_APP_PROVIDER = 3;
    short PRINCIPAL_CARD_ISSUER = 2;
    short PRINCIPAL_CARDHOLDER = 1;
    byte PROPERTY_INPUT_CONFIDENTIALITY = 1;
    byte PROPERTY_INPUT_INTEGRITY = 2;
    byte PROPERTY_OUTPUT_CONFIDENTIALITY = 4;
    byte PROPERTY_OUTPUT_INTEGRITY = 8;
    boolean isAuthenticated(short principal);
    boolean isChannelSecure(byte properties);
    boolean isCommandSecure(byte properties);
}
