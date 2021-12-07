package Blind75.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static int findLISLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]); 
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(LongestIncreasingSubsequence.findLISLength(new int[] {4,2,3,6,10,1,12}));
        System.out.println(LongestIncreasingSubsequence.findLISLength(new int[] {-4,10,3,7,15}));
    }
}
