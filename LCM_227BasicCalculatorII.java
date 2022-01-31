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
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
        s = "3/2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
        s = "3+8 / 2";
        System.out.println(LCM_227BasicCalculatorII.calculate(s));
    }
}
