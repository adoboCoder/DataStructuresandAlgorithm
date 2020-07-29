public class Solution {
    public int smallestCommonElement(int [][] mat){

        int m = mat.length;
        int n = mat[0].length;
        for(int j = 0; j < n; j++){
            int minCommon = mat[0][j];
            int i = 1;
            for(; i < m; i++){
                if(binarySearch(mat[i], minCommon)){
                    continue;
                }else{
                    break;
                }
            }
            if( i == m){
                return minCommon;
            }
        }
        return -1;
    }
    private boolean binarySearch(int [] nums, int target){
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            else if( nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }
}

//Time O(logn)
//Space O(n)