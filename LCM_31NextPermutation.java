import java.util.*;
class LCM_31NextPermutation {
    public static void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        while(k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        
        if(k == -1) { //corner case when given max
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for(int i = nums.length - 1; i > k; i--) {
            if(nums[i] > nums[k]) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, k+ 1, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}