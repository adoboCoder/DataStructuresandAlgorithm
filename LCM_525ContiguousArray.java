import java.util.*;

class LCM_525ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += -1;
            } else {
                count += 1;
            }

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input = { 0, 1, 0 };
        System.out.println(LCM_525ContiguousArray.findMaxLength(input));
    }
}