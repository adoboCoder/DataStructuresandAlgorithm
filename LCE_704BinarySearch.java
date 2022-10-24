import java.util.*;

class LCE_704BinarySearch {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(LCE_704BinarySearch.search(nums, target));
    }
}
