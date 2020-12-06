class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        return helper(n, memo);    
    }
    
    public int helper (int n, int[] memo){
        if(memo[n] > 0){
            return memo[n];
        }
        
        int waysToCurrentStairs = helper(n - 1, memo) + helper(n - 2, memo);
        memo[n] = waysToCurrentStairs;
        return waysToCurrentStairs;
    }
}

/* 
Top down DP problem.

Time: O(n)
Space: O(n)


*/ 