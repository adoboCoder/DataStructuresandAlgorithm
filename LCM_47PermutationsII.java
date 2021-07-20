import java.util.*;
// 7/19/2021

// Time: O(n!)
// Space: O(n!) ?

class LCM_47PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        Arrays.sort(nums);
        dfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }
    
    public void dfs(int[] nums, List<List<Integer>> result , List<Integer> temp, boolean[] used) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        
            for(int i = 0; i < nums.length; i++) {
                if(used[i] == true){
                    continue;
                }
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                dfs(nums, result, temp, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 7, 6};
        System.out.println(LCM_47PermutationsII.permuteUnique(input));

    }


}