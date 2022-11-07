class LCM_97InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        int m = s1.length();
        int n = s2.length();

        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean [m + 1][n + 1]);
    }

    private static boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean [][] dp) {
        if(dp[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, dp) || 
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, dp);

        if(!valid) dp[i][j] = true;
        return valid;
    }
    //TC O(m*n)
    //SC O(m+n)

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