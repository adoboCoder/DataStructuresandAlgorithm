package Blind75.String;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end;
        Set<Character> set = new HashSet<>();

        for(end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int n = LongestSubstringWithoutRepeatingCharacter.lengthOfSubstring(s);
        System.out.println(n);
    }
}
// Time: O(n)
//Space: O(n)
