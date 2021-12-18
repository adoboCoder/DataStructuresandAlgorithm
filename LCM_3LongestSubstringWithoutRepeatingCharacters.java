import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        
        for(j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}


//Slding window technique.


// String s = "ABCBCAC"
/*
     A B C B C A C
    i^
    j^
*/
