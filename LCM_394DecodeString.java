import java.util.*;
class LCM_394DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> iStack = new Stack<>();
        Stack<StringBuilder> sStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if ( c == '[') {
                iStack.push(k);
                sStack.push(sb);
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder tmp = sb;
                sb = sStack.pop();
                for (k = iStack.pop(); k > 0; k--){
                    sb.append(tmp);
                } 
            } else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[3[a]3[ec]]";
        System.out.println(LCM_394DecodeString.decodeString(s));
        s = "3[z]";
        System.out.println(LCM_394DecodeString.decodeString(s));
    }
}