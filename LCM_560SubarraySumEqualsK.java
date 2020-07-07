class Solution{
    public int subarraySum(int[] nums, int k){
        if(nums.length == 0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0,1);
        for(int i : nums){
            sum = sum + i;
            if(map.containsKey(sum - k)){
                result = result + map.get(sum-k);
            }    
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }
        return result;
    }
}
