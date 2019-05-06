package javacard.framework;

import org.junit.jupiter.api.Test;

public class UserExceptionTest extends AbstractCardExceptionTest<UserException> {
    public UserExceptionTest() {
        super(UserException.class);
    }

    @Test
    public void hasDefaultConstructor() {
        try {
            throw new UserException();
        } catch (final UserException e) {
            assertReason((short) 0, e);
        }
    }
}
