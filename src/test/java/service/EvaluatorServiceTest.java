package service;

import exception.InvalidInputException;
import org.junit.Test;
import static org.junit.Assert.*;

public class EvaluatorServiceTest {
    EvaluatorService evaluatorService;
    public EvaluatorServiceTest() {
        evaluatorService = new EvaluatorService();
    }

    @Test
    public void testExpressionEvaluation() throws InvalidInputException {
        int x = evaluatorService.evaluate("8+2*6-4/2");
        assertEquals(x, 18);
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            evaluatorService.evaluate("12/x-8/4*3+9");
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("ERROR: INVALID INPUT"));
    }
}
