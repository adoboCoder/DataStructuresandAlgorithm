import java.util.Stack;
class LCE_20ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack  = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if( c == '['){
                stack.push(']');
            }
            else if( c == '{'){
                stack.push('}');
            }
            else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        String s2 = "()[]{}";
        System.out.println(isValid(s2));
        String s3 = "(]";
        System.out.println(isValid(s3));
    }
}

// Time: O(n)
// Space: O(n)

/*
1. Build a stack
2. keep pushing closed corresponding characters ), }, or ] as long as the characters are open (, {, or [
3. If encounter a closed character, then check if stack is empty(nothing was pushed on the stack) or
    the top of the stack is != current character(closed paren).
4. If either conidion in 3 is true, there is no need to check further since it won't be matching. Note that we're popping the stack each time.
5. If all conditions above were passed, it measn we're at the end of the string.  If the stack is empty then it is a valid paren (return true)
    else they do not match(return false)


*/