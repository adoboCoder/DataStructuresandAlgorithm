class Solution{
    public int[] sortedSquears(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        
        for(int i = right; right >= 0; right--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left] * nums[left];
                left++;
            }
            else{
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}