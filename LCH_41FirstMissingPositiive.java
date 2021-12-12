import java.util.*;
class LCH_41FirstMissingPositiive {
    public static int findFirstMissingPositive(int[] nums) {
        int i = 0;
        
        while(i < nums.length) {
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= nums.length) {
                i++;
            }
            else if(nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }
        i = 0;
        
        while(i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i+ 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(LCH_41FirstMissingPositiive.findFirstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(LCH_41FirstMissingPositiive.findFirstMissingPositive(new int[] {3, 4, 1, -1}));
        System.out.println(LCH_41FirstMissingPositiive.findFirstMissingPositive(new int[] {7,8,9,11,12}));
    }
}