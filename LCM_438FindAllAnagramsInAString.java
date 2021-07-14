import java.util.*;

public class LCM_438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        int[] hash = new int[256]; // Character Hash

        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {

            if (hash[s.charAt(right)] >= 1) {
                count--;
            }

            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }

    public List<Integer> findAnagrams_1(String s, String p) {
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
}