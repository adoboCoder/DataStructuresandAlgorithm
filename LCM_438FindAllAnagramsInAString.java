import java.util.*;

public class LCM_438FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] charCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            charCount[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        int toVisit = p.length();
        while (right < s.length()) {

            if (charCount[s.charAt(right) - 'a'] >= 1) {
                toVisit--;
            }
            charCount[s.charAt(right) - 'a']--;
            right++;

            if (toVisit == 0)
                result.add(left);

            if (right - left == p.length()) {
                if (charCount[s.charAt(left) - 'a'] >= 0) {
                    toVisit++;
                }
                charCount[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";

        System.out.println(LCM_438FindAllAnagramsInAString.findAnagrams(s1, s2));
    }
}