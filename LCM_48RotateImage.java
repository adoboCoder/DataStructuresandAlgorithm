import java.util.*;
//clockwise rotation
class LCM_48RotateImage {
    public static void rotateClockwise(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        } 
            
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int first = 0, last = rows - 1; first < last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


// Counter-clockwise Rotation

    public static void rotateCounterClockwise(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int first = 0, last = cols - 1; first < last; first++, last--) {
            for(int i = 0; i < matrix.length; i++) {
                int tmp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = tmp;
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10} , {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println();
        rotateClockwise(matrix);
        rotateClockwise(matrix2);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println();
        rotateCounterClockwise(matrix);
        rotateCounterClockwise(matrix2);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(matrix2));
    }

}