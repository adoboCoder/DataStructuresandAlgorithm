import java.util.*;

class LCE_1941CheckIfAllCharactersHaveEqualNumberOfOccurences {
    public static boolean areOccurrencesEqual(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int charFrequency = map.get(s.charAt(0));
        for (char c : map.keySet()) {
            if (map.get(c) != charFrequency) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abacbc";
        String s1 = "aaabb";

        System.out.println(LCE_1941CheckIfAllCharactersHaveEqualNumberOfOccurences.areOccurrencesEqual(s));
        System.out.println(LCE_1941CheckIfAllCharactersHaveEqualNumberOfOccurences.areOccurrencesEqual(s1));
    }
}