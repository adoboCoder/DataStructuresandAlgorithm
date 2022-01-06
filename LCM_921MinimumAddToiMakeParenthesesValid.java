class LCM_921MinimumAddToiMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        int leftBracket = 0;
        int rightBracket = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightBracket++;
            } else if (rightBracket > 0) {
                rightBracket--;
            } else {
                leftBracket++;
            }
        }
        return leftBracket + rightBracket;
    }

    public static void main(String[] args) {
        System.out.println(LCM_921MinimumAddToiMakeParenthesesValid.minAddToMakeValid("())"));
        System.out.println(LCM_921MinimumAddToiMakeParenthesesValid.minAddToMakeValid("((("));
    }
}