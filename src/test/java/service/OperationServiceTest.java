package service;

import org.junit.Test;
import static org.junit.Assert.*;


public class OperationServiceTest {
    OperationService operationService;
    public OperationServiceTest() {
        operationService = new OperationService();
    }
    @Test
    public void testGetPrecedence_operators() {
        int x = operationService.getPrecedence('+');
        int y = operationService.getPrecedence('*');
        int z = operationService.getPrecedence('$');
        assertEquals(x, 1);
        assertEquals(y, 2);
        assertEquals(z, -1);
    }
}
