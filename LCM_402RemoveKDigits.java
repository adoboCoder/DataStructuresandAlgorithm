import java.util.*;

class LCM_402RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        if(num.length() == k) return "0";
        if(num.length() == 0) return "0";
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < num.length()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        //Build the result from stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10200", 1));        
        System.out.println(removeKDigits("10", 2));
    }
}   