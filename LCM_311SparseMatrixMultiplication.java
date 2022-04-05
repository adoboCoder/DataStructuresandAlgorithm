import java.util.*;

class LCM_311SparseMatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        int[][] result = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return result;   
    }

    public static void main(String[] args) {
        int[][] A = {{1,0,0},{-1,0,3}};
        int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
        
        System.out.println(Arrays.deepToString(multiply(A, B)));
    }
}

// tc : O(A.length * A[0].length * B[0].length)
// sc O(1)