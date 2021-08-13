import java.util.*;

class LCM_139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 0; i <= n; i++) {
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
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
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        String s = "catsanddog";
        Boolean b = LCM_139WordBreak.wordBreak(s, wordDict);
        System.out.println(b);
        
    }
}