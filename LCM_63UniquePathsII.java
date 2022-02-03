class LCM_63UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : grid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(LCM_63UniquePathsII.uniquePathsWithObstacles(grid));
    }
}