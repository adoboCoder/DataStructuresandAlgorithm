import java.util.*;

class LCM_139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

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