package javacard.framework;

import static org.junit.Assert.assertEquals;

public interface Assert {
    static void assertByteEquals(final byte expected, final byte actual) {
        assertEquals(expected, actual);
    }

    static void assertShortEquals(final short expected, final short actual) {
        assertEquals(expected, actual);
    }
}
