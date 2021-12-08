package Blind75.DynamicProgramming;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(WordBreak.wordBreak("leetcode", wordDict));

        wordDict.clear();

        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(WordBreak.wordBreak("applepenapple", wordDict));

        wordDict.clear();

        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(WordBreak.wordBreak("catsandog", wordDict));
    }
}
