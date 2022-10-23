import java.util.*;

public class LCM_424LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;

        for(int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while(end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(LCM_424LongestRepeatingCharacterReplacement.characterReplacement(s, 2));

    }
}
//tc: O(n)
//sc: O(1)