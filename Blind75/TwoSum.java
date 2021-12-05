package Blind75;

import java.util.*;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
                map.put(nums[i], i);
            
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}