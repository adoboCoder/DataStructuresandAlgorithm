import java.util.*;

class LCM_1877MinimizeMaximumPairSumInArray {
    public static int minPariSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[left] + nums[right])
            right--;
            left++;
        }
        return result;
    }
}