import java.util.*;

class CombinationSum{
    public List<List<Integer>> findCombination(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start){
        if(target < 0){
            return;
        }
        else if(target == 0){
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i = start; i < nums.length; i++){
                current.add(nums[i]);
                dfs(result, current, nums, target - nums[i], i);
                current.remove(current.size() - 1);
            }
        }
    }
}