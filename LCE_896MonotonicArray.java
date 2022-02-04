class Solution {
    public boolean isMonotonic(int[] nums) {
        int inc=1;
        int dec=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] > 0)
                inc++;
            else if(nums[i] - nums[i-1] < 0)
                dec++;
            else {
                inc++; dec++;
            }
        }
        return inc == nums.length || dec == nums.length;
    }
}