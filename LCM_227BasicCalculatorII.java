import java.util.*;

class LCM_227BasicCalculatorII {
    public static int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int current = 0;
        char op = '+';
        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length; i++) {
            if(Character.isDigit(ch[i])) {
                current = current * 10 + ch[i] - '0';
            }
            if(!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length - 1) {
                if(op == '+') {
                    stack.push(current);
                } else if(op == '-') {
                    stack.push(-current);
                } else if(op == '*') {
                    stack.push(stack.pop() * current);
                } else if(op == '/') {
                    stack.push(stack.pop() / current);
                }
                op = ch[i];
                current = 0;
            } 
        }
        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
/*
TC O(N)
SC O(N) because of stack
     */

    public static int calculateWithOutStack(String s) {
        if (s == null || s.isEmpty()) return 0;

        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = c;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
    /*
    TC O(N)
    SC O(1) without using stack
    */
    public static void main(String[] args) {
        String s = "3+23*2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
        System.out.println(LCM_227BasicCalculatorII.calculateWithOutStack(s));
        s = "3/2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
        System.out.println(LCM_227BasicCalculatorII.calculateWithOutStack(s));
        s = "3+8 / 2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
        System.out.println(LCM_227BasicCalculatorII.calculateWithOutStack(s));
    }
}
