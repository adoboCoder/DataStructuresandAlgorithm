class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int runningSum = 0;
        int result = Integer.MAX_VALUE;
        
        for(right = 0; right < nums.length; right++){
            runningSum = runningSum + nums[right];
            while(runningSum >= target){
                result = Math.min(result, right + 1 - left);
                runningSum = runningSum - nums[left];
                left++;
            }
        }
        if(result != Integer.MAX_VALUE){
            return result;
        }
        else return 0;
    }        
}
