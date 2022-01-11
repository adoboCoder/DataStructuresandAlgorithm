import java.util.*;
class LCM_150EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int a;
        int b;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            }
            else if(token.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }
            else if(token.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            }
            else if(token.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }
            else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(LCM_150EvaluateReversePolishNotation.evalRPN(tokens1));
        System.out.println(LCM_150EvaluateReversePolishNotation.evalRPN(tokens2));
        System.out.println(LCM_150EvaluateReversePolishNotation.evalRPN(tokens3));
    }
}