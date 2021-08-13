import java.util.*;

class LCH_140WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        if(wordDict.size() == 0) {
            return result;
        }
        
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = true;
        }
        
        String[] wordArr = new String[s.length()];
        Set<String> dict = listToSet(wordDict);
        wordBreak(s, 0, wordArr, 0, dict, dp, result);
        return result;
    }
    private static void wordBreak(String s, int index, String[] words, int wIndex, Set<String> dict,boolean[] dp, List<String> wordBreaks) {
        if(index == s.length()){
            wordBreaks.add(wordsToString(words, wIndex));
            return;
        }
        
        for(int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if(!dict.contains(word)){
                continue;
            }
            
            words[wIndex] = word;
            wordBreak(s, i, words, wIndex + 1, dict, dp, wordBreaks);
        }
    }
    
    private static String wordsToString(String[] words, int count) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count - 1; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[count - 1]);
        return sb.toString();
    }
    
    private static Set<String> listToSet(List<String> words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
        }
        return set;
    }
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        String s = "catsanddog";
        List<String> result = LCH_140WordBreakII.wordBreak(s, wordDict);

        for(String word : result) {
            System.out.println(word);
        }
        
    }
}