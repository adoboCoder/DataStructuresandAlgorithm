import java.util.*;

class LCM90_subsets2{
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> each, int index, int[] n) {
        if (index <= n.length) {
            res.add(each);
        }
        int i = index;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }
    public static void main(String[] args) {
        System.out.println(LCM90_subsets2.subsetsWithDup(new int[] {1, 2, 2}));
    }
}

/*
Time Complexity: O(N2^N), there are 2^N possible subsets, and for each set, it takes O(N) time to copy from ArrayList to the final result list.
Space Complexity: O(N2^N)
 */