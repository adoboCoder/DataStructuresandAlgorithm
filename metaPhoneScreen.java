import java.util.*;

class metaPhoneScreenEvaluateExpression {
    public static int evaluateExpression(String s) {
        s = s.trim();
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'a') {
                stack.push("add");
                // move three positions forward, length of add word
                i = i + 3;
            } else if (s.charAt(i) == 's') {
                // move eight positions forward, length of subtract word or we could increment
                // till we find a opening bracket
                stack.push("subtract"); // can be simplified to -1 and can be used multiplied with secodNum when popping
                                        // the stack
                i = i + 8;
            } else if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                stack.push(String.valueOf(num));
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    int secondNum = Integer.parseInt(stack.pop());
                    int firstNum = Integer.parseInt(stack.pop());
                    if (stack.pop().equals("add")) {
                        int current = firstNum + secondNum;
                        stack.push(String.valueOf(current));
                    } else {
                        int current = firstNum - secondNum;
                        stack.push(String.valueOf(current));
                    }
                }
            }
            // simply ignore if you find opening braces and increment as we have already
            // pushed to the stack.
            i++;
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String s = "add(1,add(2,5))";
        String s1 = "add(add(5,6),subtract(add(2,3),add(subtract(5,1),4)))";
        System.out.println(evaluateExpression(s));
        System.out.println(evaluateExpression(s1));
    }
}