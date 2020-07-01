public class Solution{
    public int[] productExceptSelf( int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        //calculate left and store in result
        int left = 1;
        for(int i = 0; i < n ; i++){
            if ( i > 0){
                left = left * nums[i-1];
            }
            result[i] = left;
        }
    //calculate the rights, and the product from the right of the array
        int right = 1;
        for(int i = n -1; i >= 0; i--){
            if (i < n-1){
                right = right * nums[i+1];
            }
            result[i] = result[i] * right;
        }
        return result;
    }
}

// Time Complexity : O(n)
//Space Complexity : O(1)