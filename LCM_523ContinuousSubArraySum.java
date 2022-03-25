import java.util.*;
class LCM_523ContinuousSubArraySum {
    public static boolean checkSubarraySum (int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // key: remainder, value: index
        map.put(0, -1);
        
        int runningSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            if(k != 0) {
                runningSum = runningSum % k;
            }
            
            if(map.containsKey(runningSum)){
                if(i - map.get(runningSum) >= 2) {
                    return true;
                }
            }
            else map.put(runningSum, i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(LCM_523ContinuousSubArraySum.checkSubarraySum(nums, k));
        int[] nums2 = {23,2,6,4,7};
        int k2 = 6;
        System.out.println(LCM_523ContinuousSubArraySum.checkSubarraySum(nums2, k2));
        int[] nums3 = {23,2,6,4,7};
        int k3 = 13;
        System.out.println(LCM_523ContinuousSubArraySum.checkSubarraySum(nums3, k3));
    }
    
}

/*
    TC: O(N)
    SC: O(N)
*/