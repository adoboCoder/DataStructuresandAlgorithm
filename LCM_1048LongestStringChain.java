import java.util.*;

class LCM_1048LongestStringChain {
    public static int longestStringChain(String[] words) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            map.put(word, 1);
            for(int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String next = current.deleteCharAt(i).toString();

                if(map.containsKey(next)) {
                    map.put(word, Math.max(map.get(word), map.get(next) + 1));
                }
            }
            result = Math.max(result, map.get(word));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = { "bdca", "b", "ba", "bca", "bda", "a" };
        System.out.println(LCM_1048LongestStringChain.longestStringChain(input));
        String[] input2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(LCM_1048LongestStringChain.longestStringChain(input2));
    }
}