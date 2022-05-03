package service;

public class OperationService {
    public int getPrecedence(char c) {
        //Higher the precedence of operation, higher is it's numbered returned.
        switch(c) {
            //Keep these values this way only.
            case '+': return 1;
            case '-': return 1;

            case '*': return 2;
            case '/': return 2;

            //case '^': return 3;
        }
        return -1;
    }

    public int performOperation(int a, int b, char op) {
        switch(op) {
            //b is on the top in operand stack, compared to a
            case '+': return b+a;
            case '-': return b-a;
            case '*': return b*a;
            case '/':
                if(b==0)
                    throw new UnsupportedOperationException("Div by 0 not valid");
                return b/a;
        }
        return 0;
    }

    public boolean isOperator(char c) {
        return (c=='+' || c=='-' || c =='*' || c=='/');
    }
}
