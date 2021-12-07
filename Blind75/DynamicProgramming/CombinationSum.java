package Blind75.DynamicProgramming;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> findCombination(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, target, new ArrayList<>());
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int start, int remain, List<Integer> temp) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(result, nums, i, remain - nums[i], temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(CombinationSum.findCombination(new int[] { 2, 3, 6, 7 }, 7));
    }
}
