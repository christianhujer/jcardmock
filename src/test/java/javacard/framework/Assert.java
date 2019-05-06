package javacard.framework;

import static org.junit.jupiter.api.Assertions.assertEquals;

public enum Assert {
    ;
    public static void assertByteEquals(final byte expected, final byte actual) {
        assertEquals(expected, actual);
    }

    public static void assertShortEquals(final short expected, final short actual) {
        assertEquals(expected, actual);
    }
}
