import java.util.*;

class LCM_1877MinimizeMaximumPairSumInArray {
    public static int minPariSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            result = Math.max(result, nums[left] + nums[right]);
            right--;
            left++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        System.out.println(LCM_1877MinimizeMaximumPairSumInArray.minPariSum(nums));
        int[] nums2 = {3,5,4,2,4,6};
        System.out.println(LCM_1877MinimizeMaximumPairSumInArray.minPariSum(nums2));
        
    }
}