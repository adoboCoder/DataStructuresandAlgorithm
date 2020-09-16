class Solution{
    public int maxSubArray(int[] A){
        int max = A[0];
        int maxEnd = A[0];

        for(int i = 1; i < A.length; i++){
            maxEnd = Math.max(maxEnd + A[i], A[i]);
            max = Math.max(max, maxEnd);
        }
        return max;
    }
}