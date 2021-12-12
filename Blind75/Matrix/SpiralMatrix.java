
package Blind75.Matrix;
import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        // right, down, left, up
        while(rowStart <= rowEnd && colStart <= colEnd) {
            
            for(int i = colStart; i <= colEnd; i++) { //right
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

              for(int i = rowStart; i <= rowEnd; i++) { //down
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowEnd >= rowStart) {
                for(int i = colEnd; i >= colStart; i--) { //left
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) { //up
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(SpiralMatrix.spiralOrder(matrix));
    }
}
