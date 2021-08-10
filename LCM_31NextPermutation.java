class LCM_31NextPermutation {
    public static void nextPermutation(int[] A) {
        int k = A.length - 2;
        while (k >= 0 && A[k] >= A[k + 1]){
            k--;
        }
        
        //Corer case where the given  permutation is already the max
        if(k == -1) {
            reverse(A, 0, A.length - 1);
            return;
        }
        
        for(int l = A.length -1; l > k; l--) {
            if(A[l] > A[k]) {
                int temp = A[k];
                A[k] = A[l];
                A[l] = temp;
                break;
            }
        }
        
        reverse(A, k + 1, A.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }    
}   