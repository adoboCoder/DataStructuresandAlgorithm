class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(target - nums[i])){
                result [0] = i;
                result [1] = hash.get(target - nums[i]);
            }
        hash.put(nums[i], i);
        }
        return result;
    }
}

//Time: O(n)
//Space: O(n)