import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer, Integer> map = new HashMap();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 
        Set<Integer> set = new HashSet();
        for(int key : map.keySet()){
            if(!set.add(map.get(key))){
                return false;
            }
        }
        return true;
    }
}