import java.util.*;
class LCM_78Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // start by adding the empty subset
        result.add(new ArrayList<>());
        for (int currentNumber : nums) {
        // we will take all existing subsets and insert the current number in them to create new subsets
            int n = result.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(currentNumber);
                result.add(temp);
        }
    }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(LCM_78Subsets.subsets(nums));
    }
}

// Time O(n * 2^n)
// Space O(n * 2^n)