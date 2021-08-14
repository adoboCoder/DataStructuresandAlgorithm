import java.util.*;
class LCM_523ContinuousSubArraySum {
    public static boolean checkSubarraySum (int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int runningSum = 0;
        
        for(int i = 0; i < nums.length; i ++) {
            runningSum = runningSum + nums[i];
            if(k != 0) {
                runningSum = runningSum % k;
            }
            
            Integer prev = map.get(runningSum);
            
            if(prev != null) {
                if(i - prev > 1) {
                    return true;
                }
            }
            else map.put(runningSum, i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 8, 8, 29, 2};
        int k = 12;
        System.out.println(LCM_523ContinuousSubArraySum.checkSubarraySum(nums, k));
    }
    
}