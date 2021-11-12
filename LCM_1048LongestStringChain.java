import java.util.*;

class LCM_1048LongestStringChain {
    public static int longestStringChain(String[] words) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, map.getOrDefault(prev, 0) + 1);
            }
            map.put(word, best);
            result = Math.max(result, best);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = { "a", "b", "ba", "bca", "bda", "bdca" };
        System.out.println(LCM_1048LongestStringChain.longestStringChain(input));
    }
}