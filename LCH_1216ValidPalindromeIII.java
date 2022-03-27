class LCH_1216ValidPalindromeIII {
    public static boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                } 
            }
        }
        return dp[0][n - 1] <= k;
    }
    public static void main(String[] args) {
        String s = "abcdeca";
        int k = 2;

        System.out.println(isValidPalindrome(s, k));
    }
}
// TC (N^2)  n is the length of string s
// SC (N^2) n is the length of string s