class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(matrix.length == 0){
            return result;
        }
        
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length -1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            
            // Traverse Right
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;
            
            // Traverse Down
            for (int j = rowStart; j <= rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowStart; j--) {
                    result.add(matrix[j][colStart]);
                }
            }
            colStart ++;

        }
            return result;
    }
}