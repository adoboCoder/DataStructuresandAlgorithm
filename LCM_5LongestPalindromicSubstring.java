class LCM_5LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            int length1 = expandFromMiddle(s, i, i); // 
            int length2 = expandFromMiddle(s, i, i + 1);

            int maxLength = Math.max(length1, length2);
            if(maxLength > end - start) {
                start = i - ((maxLength - 1) / 2);
                end = i + (maxLength / 2); 

            }
        }
        return s.substring(start, end + 1);
    }
    public static int expandFromMiddle(String s, int left, int right)  {
        if(s == null || left > right) return 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(LCM_5LongestPalindromicSubstring.longestPalindrome(s));
        s = "cbbd";
        System.out.println(LCM_5LongestPalindromicSubstring.longestPalindrome(s));
        s = "racecar";
        System.out.println(LCM_5LongestPalindromicSubstring.longestPalindrome(s));
    }
}