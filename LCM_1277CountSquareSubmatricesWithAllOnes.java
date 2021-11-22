class LCM_1277CountSquareSubMatricesWithAllOnes {
    public static int countSquares(int[][] dprix) {
        int dp[][] = new int[dprix.length + 1][dprix[0].length + 1];
        int sum = 0;
        
        for(int i = 1; i <= dprix.length; i++){
            for(int j = 1; j <= dprix[0].length; j++){
                if(dprix[i - 1][j - 1] != 0)
                    sum += (dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1);
        
            }
        }      
    return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {0,1,1,1},
                            {1,1,1,1},
                            {0,1,1,1} };
        System.out.println(LCM_1277CountSquareSubMatricesWithAllOnes.countSquares(matrix)); 
    }
}