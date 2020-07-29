public class Solution {
    public boolean isMajorityElement(int[] nums, int target){
        int firstIndex = binarySearch(nums, target);
        int lastIndex = firstIndex + nums.length / 2;
         
        return lastIndex < nums.length && nums[lastIndex] == target;
    }

    private int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] >= target){
                right = mid;
            }
        }
        return left;
    }
}
//Time: O(log N)
//Space: O(N)