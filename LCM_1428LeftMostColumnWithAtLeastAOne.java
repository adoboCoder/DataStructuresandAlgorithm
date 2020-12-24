class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int m = dimension.get(0); //row
        int n = dimension.get(1); //col 
        int ans = -1;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                ans = col; // record as current ans
                col--;
            } else {
                row++;
            }
        }
        return ans;
    }
}