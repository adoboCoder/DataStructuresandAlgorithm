import java.util.*;

class LCM_720LongesWordInDictionary {
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        if (words.length == 0 || words == null)
            return result;

        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                result = word.length() > result.length() ? word : result;
                set.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(LCM_720LongesWordInDictionary.longestWord(words));
    }
}