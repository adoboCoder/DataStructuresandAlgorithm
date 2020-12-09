class Solution{
    public List<List<Integer>> combinationSum2(int [] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int start){
        if(remain < 0){
            return;
        }
        else if(remain == 0){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < nums.length; i++){
                if( i > start && nums[i] == nums[i - 1]){
                    continue; // skip duplicates
                }
                temp.add(nums[i]);
                dfs(result, temp, nums, remain - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}