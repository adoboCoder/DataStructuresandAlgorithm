class LCH_329LongestIncreasingPathInAMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, dp, -1));
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int i, int j, int[][] dp, int current) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] <= current) {
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }
        result = Math.max(result, 1 + dfs(grid, i + 1, j, dp, grid[i][j]));
        result = Math.max(result, 1 + dfs(grid, i, j + 1, dp, grid[i][j]));
        result = Math.max(result, 1 + dfs(grid, i - 1, j, dp, grid[i][j]));
        result = Math.max(result, 1 + dfs(grid, i, j - 1, dp, grid[i][j]));

        dp[i][j] = result;
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix =    {
                                {9, 9, 4},
                                {6, 6, 8},
                                {2, 1, 1}
                            };
        System.out.println(LCH_329LongestIncreasingPathInAMatrix.longestIncreasingPath(matrix));
    }
}