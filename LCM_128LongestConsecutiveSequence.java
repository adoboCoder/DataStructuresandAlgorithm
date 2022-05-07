import java.util.*;

class LCM_128LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, true);
        }
        
        int result = 0;
        for(int n : nums){
            if(!map.get(n)) continue;
        
            map.put(n, false);
            int current = 1;
            int left = n - 1;
            int right = n + 1;
            
            while(map.containsKey(left)) {
                map.put(left, false);
                left--;
                current++;
            }
            
            while(map.containsKey(right)) {
                map.put(right, false);
                right++;
                current++;
            }
            if(current > result) {
                result = current;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
}

//TC: O(N)
//SC: O(N)