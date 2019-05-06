package javacard.framework.service;

import javacard.framework.AbstractCardExceptionTest;
import org.junit.jupiter.api.Test;

import static javacard.framework.Assert.assertShortEquals;
import static javacard.framework.service.ServiceException.*;

public class ServiceExceptionTest extends AbstractCardExceptionTest<ServiceException> {
    public ServiceExceptionTest() {
        super(ServiceException.class);
    }

    @Test
    public void testConstants() {
        assertShortEquals((short) 4, CANNOT_ACCESS_IN_COMMAND);
        assertShortEquals((short) 5, CANNOT_ACCESS_OUT_COMMAND);
        assertShortEquals((short) 3, COMMAND_DATA_TOO_LONG);
        assertShortEquals((short) 6, COMMAND_IS_FINISHED);
        assertShortEquals((short) 2, DISPATCH_TABLE_FULL);
        assertShortEquals((short) 1, ILLEGAL_PARAM);
        assertShortEquals((short) 7, REMOTE_OBJECT_NOT_EXPORTED);
    }
}
