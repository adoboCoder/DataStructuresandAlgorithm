class LCM_921MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int openCount = 0;
        int closeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++openCount;
            } else {
                if (openCount > 0) {
                    --openCount;
                } else {
                    ++closeCount;
                }
            }
        }

        return openCount + closeCount;
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(LCM_921MinimumAddToMakeParenthesesValid.minAddToMakeValid(s));

    }
}