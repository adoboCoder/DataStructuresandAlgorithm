import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet();
        for(int i : nums1){
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet();
        for(int j: nums2){
            set2.add(j);
        }

        set1.retainAll(set2);

        int[] result = new int[set1.size()];

        int k = 0
        for(int num: set1){
            result[k++] = num;
        }
        return result;
    }
}

//Time: O(n)
