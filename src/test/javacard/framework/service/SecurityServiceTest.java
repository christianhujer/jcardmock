package javacard.framework.service;

import org.junit.Test;

import static javacard.framework.Assert.assertByteEquals;
import static javacard.framework.Assert.assertShortEquals;
import static javacard.framework.service.SecurityService.*;

public class SecurityServiceTest {

    @Test
    public void testConstants() {
        assertShortEquals((short) 3, PRINCIPAL_APP_PROVIDER);
        assertShortEquals((short) 2, PRINCIPAL_CARD_ISSUER);
        assertShortEquals((short) 1, PRINCIPAL_CARDHOLDER);
        assertByteEquals((byte) 1, PROPERTY_INPUT_CONFIDENTIALITY);
        assertByteEquals((byte) 2, PROPERTY_INPUT_INTEGRITY);
        assertByteEquals((byte) 4, PROPERTY_OUTPUT_CONFIDENTIALITY);
        assertByteEquals((byte) 8, PROPERTY_OUTPUT_INTEGRITY);
    }
}
