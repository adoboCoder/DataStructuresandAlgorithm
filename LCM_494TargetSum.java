
class LCM_494TargetSum {
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   
    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int s = 3;
        System.out.println(LCM_494TargetSum.findTargetSumWays(nums, s));
    }
}