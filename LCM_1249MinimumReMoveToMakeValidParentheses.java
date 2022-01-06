class LCM_1249MinimumReMoveToMakeValidParentheses { 
    public static String minRemoveToMakeValid(String s) {
        int openCloseCount = 0;
        int close = 0;
        for(char c : s.toCharArray()){
            if(c == ')') close++;
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if (c == '(') {
                if (openCloseCount == close) {
                    continue;
                }
                openCloseCount++;  
            } else if (c == ')') {
                close--;
                if (openCloseCount == 0) {
                    continue;
                }
                openCloseCount--;
            } 
                sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(LCM_1249MinimumReMoveToMakeValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}

    //Time O(n)
    //Space O(n)