class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                increase = true;
            }
            if (A[i] > A[i + 1]) {
                decrease = true;
            }
        }       
        return increase && decrease ? false : true;
    }
}