class LCM_1277CountSquareSubmatricesWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int mat[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int sum = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] != 0)
                    sum += (mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
        System.out.println(LCM_1277CountSquareSubmatricesWithAllOnes.countSquares(matrix));
    }
}