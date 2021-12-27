class LCM_1277CountSquareSubmatricesWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int result = 0;
        
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = result + dp[i][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix =    {
                                {0,1,1,1},
                                {1,1,1,1},
                                {0,1,1,1}
                            };
        System.out.println(LCM_1277CountSquareSubmatricesWithAllOnes.countSquares(matrix));
    }
}