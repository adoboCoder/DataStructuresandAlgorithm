import java.util.*;

class LCM_1647MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public static int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);
        int keep = freq[25];
        int prev = keep;

        for (int i = 24; i >= 0 && freq[i] != 0 && prev != 0; i--) {
            prev = Math.min(freq[i], prev - 1);
            keep += prev;
        }

        return s.length() - keep;
    }

    public static void main(String[] args) {
        System.out.println(LCM_1647MinimumDeletionstoMakeCharacterFrequenciesUnique.minDeletions("aab"));
        System.out.println(LCM_1647MinimumDeletionstoMakeCharacterFrequenciesUnique.minDeletions("aaabbbcc"));
        System.out.println(LCM_1647MinimumDeletionstoMakeCharacterFrequenciesUnique.minDeletions("ceabaacb"));
    }
}