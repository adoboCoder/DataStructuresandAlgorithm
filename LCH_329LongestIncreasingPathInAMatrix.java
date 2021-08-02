class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0; 
        int[][] memo = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                result = Math.max(result, dfs(matrix, i, j, memo, -1));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo, int current){
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] < current) {
            return 0;
        }

        if(memo[i][j] != 0){
            return memo[i][j];
        }

        result = Math.max(result, dfs(matrix, i + 1, j, memo, matrix[i][j]));
        result = Math.max(result, dfs(matrix, i - 1, j, memo, matrix[i][j]));
        result = Math.max(result, dfs(matrix, i, j + 1, memo, matrix[i][j]));
        result = Math.max(result, dfs(matrix, i, j - 1, memo, matrix[i][j]));
        result++;
        memo[i][j] = result;
        return result;
    }
}