import java.util.*;

class LCE_167TwoSumIIInputArrayIsSorted {
    public static int[] twoSum (int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if(nums[left] + nums[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            else if(nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }
}