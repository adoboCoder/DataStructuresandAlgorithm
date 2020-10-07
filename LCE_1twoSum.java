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

/*
 This problem utilizes a hashmap data structure, it uses the logic of target - nums[index] to find the corresponding 
operand in the hash table.  If there isn't a match in the hashTable, then put the values and the lookup index in the hash map 
hash.put(nums[i],i)

If there is a match, store the following in the result array of size 2; size is two because of it takes two operands to sum up to the target.
result[0] would be index
result[1] would be a hash map lookup hash.get(target - nums[i])

*/