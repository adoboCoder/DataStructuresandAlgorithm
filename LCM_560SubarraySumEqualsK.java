import java.util.*;

class LCM_560SubarraySumEqualsK{
    public static int subarraySum(int[] nums, int k){
        int sum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();// key: sum , val: sum freq.
        map.put(0, 1);

        for(int i = 0; i < nums. length; i++) {
            sum = sum + nums[i];

            if(map.containsKey(sum - k)) {
                result = result + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, -1, 0};
        System.out.println(Arrays.toString(test));
        System.out.println(LCM_560SubarraySumEqualsK.subarraySum(test, 0));
    }
}
// TC O(n)
// SC O(n)