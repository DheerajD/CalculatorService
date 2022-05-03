package service;

import exception.InvalidInputException;
import java.util.Stack;

//Referred link: https://algorithms.tutorialhorizon.com/evaluation-of-infix-expressions/
//The below code handles:
// 1. Spaces in expression
// 2. alphabets or any other symbol not allowed(only numbers and DMAS operations supported.)

public class EvaluatorService {
    OperationService op;

    public EvaluatorService() {
        op = new OperationService();
    }
    public int evaluate(String expression) throws InvalidInputException {
        //We'll take 2 stacks, one for numbers and other one for operator
        Stack<Integer> number = new Stack<>();
        Stack<Character> operator = new Stack<>();

        //Now we'll traverse the expression to be evaluated.
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)) {
                int num=0;
                while(Character.isDigit(c)) {
                    num = num*10 + (c-'0');
                    i++;

                    if(i<expression.length())
                        c=expression.charAt(i);
                    else
                        break;
                }
                i--;    //to undo extra increment that happened in last iteration
                number.push(num);
            }
            else if(op.isOperator(c)) {
                while(!operator.isEmpty() && op.getPrecedence(c)<=op.getPrecedence(operator.peek())) {
                    int a = number.pop();
                    int b = number.pop();
                    char cTemp = operator.pop();
                    int out = op.performOperation(a, b, cTemp);
                    number.push(out);
                }
                operator.push(c);
            }
            else if(c==' ')
                continue;
            else {
                throw new InvalidInputException("ERROR: INVALID INPUT");
            }
        }
        while(!operator.isEmpty()) {
            int a = number.pop();
            int b = number.pop();
            char cTemp = operator.pop();
            //System.out.println("test1 eval:" +b+""+cTemp+a+"");
            int out = op.performOperation(a, b, cTemp);
            //System.out.println("test1 log out:" +out);
            number.push(out);
        }
        return number.pop();
    }
}
