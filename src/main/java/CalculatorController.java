import exception.InvalidInputException;
import service.EvaluatorService;

public class CalculatorController {
    public static void main(String args[]) {
        EvaluatorService evaluatorService = new EvaluatorService();

        System.out.println("Hello from Calculator service");
        try {
            System.out.println("Test1 result = " + evaluatorService.evaluate("8+2*6-4/2"));
            System.out.println("Test2 result = " + evaluatorService.evaluate("8+2*6 -4/2"));
            System.out.println("Test3 result = " + evaluatorService.evaluate("8+2*   6 -4/2"));
            System.out.println("Test4 result = " + evaluatorService.evaluate("5-9*3"));//-22
            System.out.println("Test5 result = " + evaluatorService.evaluate("12/3-8/4*3+9"));//7
            //System.out.println("Test6 result = " + evaluatorService.evaluate("12/x-8/4*3+9"));//Invalid input exception
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
