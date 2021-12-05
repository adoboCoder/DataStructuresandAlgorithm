package Blind75.Arrays;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;
        
        if(nums == null || n == 0) {
            return -1;
        }

        int left = 0;
        int right = n -1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
