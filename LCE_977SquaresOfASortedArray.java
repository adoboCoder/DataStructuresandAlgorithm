import java.util.*;
class LCE_977SquaresOfASortedArray{
    public static int[] sortedSquares(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        
        for(int i = right; i >= 0; i--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left] * nums[left];
                left++;
            }
            else{
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {-4,-1,0,3,10};
        int[] nums2 = {-7,-3,2,3,11};

        System.out.println(Arrays.toString(LCE_977SquaresOfASortedArray.sortedSquares(nums1)));
        System.out.println(Arrays.toString(LCE_977SquaresOfASortedArray.sortedSquares(nums2)));
    }
}