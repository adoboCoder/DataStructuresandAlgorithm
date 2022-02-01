import java.util.*;

class LCM_325MaximumSizeSumEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k)) {
                result = Math.max(result, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, -1, 5, -2, 3 };
        int k = 3;
        System.out.println(LCM_325MaximumSizeSumEqualsK.maxSubArrayLen(nums, k));
        int[] nums2 = {-2,-1,2,1};
        int k2 = 3;
        System.out.println(LCM_325MaximumSizeSumEqualsK.maxSubArrayLen(nums2, k2));
    }

}