import java.util.Arrays;

class Partition {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        sum = sum / 2;

        boolean dp[][] = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < sum; i++) {
            dp[0][i] = (nums[0] == i ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println();
        return dp[n - 1][sum];

    }

    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4 };
        System.out.println(Partition.canPartition(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(Partition.canPartition(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(Partition.canPartition(num));
    }
}