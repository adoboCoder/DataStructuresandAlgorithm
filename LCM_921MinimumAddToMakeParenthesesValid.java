class LCM_921MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
            int leftBracket = 0;
            int rightBracket = 0;
            for(char c : s.toCharArray()) {
                if(c == '(') {
                    leftBracket++;
                } else {
                    if (leftBracket > 0) {
                        leftBracket--;
                    } else {
                        rightBracket++;
                    }
                }
            }
        return leftBracket + rightBracket;
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(LCM_921MinimumAddToMakeParenthesesValid.minAddToMakeValid(s));
        s = "(((";
        System.out.println(LCM_921MinimumAddToMakeParenthesesValid.minAddToMakeValid(s));
    }
}