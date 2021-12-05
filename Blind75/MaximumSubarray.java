package Blind75;

public class MaximumSubarray {
    public static int findMaxSubarray (int[] nums) {
        int max = nums[0];
        int globalMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSubarray.findMaxSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(MaximumSubarray.findMaxSubarray(new int[] {1}));
    }
}
