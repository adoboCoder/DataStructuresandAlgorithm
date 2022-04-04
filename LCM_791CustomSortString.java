import java.util.*;

class LCM_791CustomSortString {
    public static String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a']; 
        }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {                            
            while (count[c - 'a']-- > 0) {
                sb.append(c); 
            }    // sort chars both in s and ORDER by the order of ORDER.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c); 
            }    // group chars in s but not in ORDER.
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(LCM_791CustomSortString.customSortString(order, s));
        order = "cbafg";
        s = "abcd";
        System.out.println(LCM_791CustomSortString.customSortString(order, s));
    }
}
/*

TC: O(N) n = t.length()
SC: O(N) n = t.length()
*/