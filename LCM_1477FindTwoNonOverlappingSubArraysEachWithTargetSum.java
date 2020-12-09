class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int lsize = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        map.put(0,-1);
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            map.put(sum,i); // stores key as sum upto index i, and value as i.
        }
        sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(map.get(sum - target) != null){
                lsize = Math.min(lsize,i - map.get(sum - target));      // stores minimum length of sub-array ending with index<= i with sum target. This ensures non- overlapping property.
            }
			//map.get(sum+target) searches for any sub-array starting with index i+1 with sum target.
            if(map.get(sum + target) != null && lsize<Integer.MAX_VALUE){
                result = Math.min(result,map.get(sum + target) - i + lsize); // updates the result only if both left and right sub-array exists.
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}