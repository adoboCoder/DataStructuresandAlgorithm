class LCE_70ClimbingStairs {
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return helperTopDown(n, memo);
    }

    public static int helperTopDown(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }

        int waysToCurrentStairs = helperTopDown(n - 1, memo) + helperTopDown(n - 2, memo);
        memo[n] = waysToCurrentStairs;
        return waysToCurrentStairs;
    }

    public static int climbStairsBottomup(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("TopDown: " + LCE_70ClimbingStairs.climbStairs(3));
        System.out.println("BottomUp: " + LCE_70ClimbingStairs.climbStairsBottomup(3));
    }
}

/*
 * Top down DP problem.
 * 
 * Time: O(n)
 * Space: O(n)
 * 
 * 
 */