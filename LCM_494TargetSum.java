import java.util.*;

class LCM_494TargetSum {
    public static int findTargetSumWays(int[] nums, int s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap<>();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }
        return dp.getOrDefault(s, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int s = 3;
        System.out.println(LCM_494TargetSum.findTargetSumWays(nums, s));
    }
}