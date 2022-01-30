class LCM_678ValidParenthesisString {
    public static boolean checkValidString(String s) {
        if(s == null || s.length() == 0) return false;
        int min = 0;
        int max = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                min++;
                max++;
            }
            else if (c == ')') {
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }

            if(max < 0) return false;
            min = Math.max(min, 0);
        }
        return min == 0;
    }
    public static void main(String[] args) {
        String s = "()";
        System.out.println(LCM_678ValidParenthesisString.checkValidString(s));
        s = "(*)";
        System.out.println(LCM_678ValidParenthesisString.checkValidString(s));
        s = "*()(*)";
        System.out.println(LCM_678ValidParenthesisString.checkValidString(s));
    }
}