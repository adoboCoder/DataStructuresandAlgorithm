class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            tempMax = Math.max(nums[i], tempMax + nums[i]);
            max = Math.max(tempMax, max);
        }
        return max;
    }
}

/*
nums = [-2,1,-3,4,-1,2,1,-5,4] 

We need two variables to store a temporary max, and while computing a temp max we would continuously compare with previous 
temp maxes to get a currentMax.

For example:

tempMax = -2 // The first element of the nums array (nums[0])

by adding the next element nums[1] (1) 

we would be choosing a new max between:

1 and -2 + 1 (new contender)

the new tempMax is now 1.


The same prcoess can be done to find the max, initially tempMax is also the first element. 
After the first iteration, it becomes -1 



See Kadane's Algorithm for more details.

*/
