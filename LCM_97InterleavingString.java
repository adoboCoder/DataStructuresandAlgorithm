class LCM_97InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }
    // TC O(m*n)
    // SC O(m+n)

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(LCM_97InterleavingString.isInterleave(s1, s2, s3));

        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(LCM_97InterleavingString.isInterleave(s1, s2, s3));

        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println(LCM_97InterleavingString.isInterleave(s1, s2, s3));
    }
}