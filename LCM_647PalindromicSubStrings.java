class LCM_647PalindromicSubStrings {
    public static int count(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += extend(s, i, i);
            result += extend(s, i, i + 1);
        }
        return result;
    }

    public static int extend(String s, int start, int end) {
        int result = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(count("abc"));
        System.out.println(count("aaa"));
    }
}