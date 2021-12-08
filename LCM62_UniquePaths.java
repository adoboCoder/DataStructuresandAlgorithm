import java.util.Arrays;

class LCM62_UniquePaths {
    public static int findUniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;

        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(LCM62_UniquePaths.findUniquePaths(3, 7));
    }
}