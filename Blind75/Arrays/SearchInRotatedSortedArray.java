package Blind75.Arrays;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
                if(target > nums[mid] || target < nums[left]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                if(target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(SearchInRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(SearchInRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 3));
    }
}