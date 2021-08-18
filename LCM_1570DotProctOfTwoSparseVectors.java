import java.util.*;

class SparseVector {
    public Map<Integer, Integer> indexValueMap;

    SparseVector(int[] nums) {
        indexValueMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                indexValueMap.put(i, nums[i]);
            }
        }
    }

    public int dotProoduct(SparseVector vec) {
        int product = 0;

        for(int n : indexValueMap.keySet()) {
            if(vec.indexValueMap.containsKey(n)) {
                product += indexValueMap.get(n) * vec.indexValueMap.get(n);
            }
        }
        return product;
    }
}