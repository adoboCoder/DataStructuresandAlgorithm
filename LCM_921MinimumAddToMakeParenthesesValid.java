class LCM_921MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
            int leftBracket = 0;
            int rightBracket = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
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