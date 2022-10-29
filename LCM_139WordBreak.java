import java.util.*;

class LCM_139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> workDictSet = new HashSet<>(wordDict);

        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }

        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (
                    ((i + word.length()) <= s.length()) &&
                    (s.substring(i, i + word.length()).startsWith(word))
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }


//Bottom up approach
//TC: O(n^2 * m)
//SC: O(n)

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cats");
        String s = "catsandog";
        Boolean b = LCM_139WordBreak.wordBreak(s, wordDict);
        System.out.println(b);

        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("apple");
        wordDict1.add("pen");
        String s1 = "applepenapple";
        System.out.println(LCM_139WordBreak.wordBreak(s1, wordDict1));
    }
}