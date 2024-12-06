package stack;

import java.util.Stack;

public class PostFixExpressionEvaluation {

    public static void main(String[] args){
        System.out.println(postFixEvaluate("231*+9-"));
    }


    public static int postFixEvaluate(String str) {
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (Character val : arr) {
            if (isOperator(val)) {
                Character val1 = stack.pop();
                Character val2 = stack.pop();
                stack.push(performOperation(val1, val2, val));
            } else {
                stack.push(val);
            }
        }



        return stack.pop() - '0';
    }

    static boolean isOperator(Character ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            return true;

        return false;
    }

    static char performOperation(Character val1, Character val2, Character val) {
        int a = val1 - '0';
        int b = val2 - '0';

        int result = 0;

        switch (val) {
            case '+' -> result =  (a + b);
            case '-' -> result =  (a - b);
            case '*' -> result =  (a * b);
            case '/' -> result =  (a / b);
            case '^' -> result =  (a ^ b);
        }

        return (char) (result + '0');
    }
}
