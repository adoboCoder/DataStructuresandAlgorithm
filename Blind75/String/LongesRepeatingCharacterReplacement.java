package Blind75.String;

public class LongesRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int start = 0;
        int maxCount = 0;
        int result = 0;

        for(int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++map[s.charAt(end) - 'A']);
            while(end - start + 1 - maxCount > k) {
                map[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(LongesRepeatingCharacterReplacement.characterReplacement(s, k));
        s = "AABABBA";
        k = 1;
        System.out.println(LongesRepeatingCharacterReplacement.characterReplacement(s, k));
    }
}
