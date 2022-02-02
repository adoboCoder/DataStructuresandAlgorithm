import java.util.*;

class LCE_163MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            result.add(formRange(lower,upper));
            return result;
        }
        // 1st step
        if (nums[0] > lower){
            result.add(formRange(lower,nums[0]-1));
        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(formRange(nums[i]+1, nums[i+1]-1));
            }
        }

       // 3rd step
        if (nums[nums.length-1] < upper){
            result.add(formRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }
    
    public static String formRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;

        System.out.println(LCE_163MissingRanges.findMissingRanges(nums, lower, upper));
    }

/*
Time: O(n)
Space: O(1)

Going through the nums array with the for loop.  There are two conditions in the loop.  
1. current > lower which means the current number is in the range between lower and upper.  We print the sequence.
2. current == upper means that we've gone through the whole sequence already
3. If either of the two above are true, then we need to update the lower by adding 1 to lower.
*/
}