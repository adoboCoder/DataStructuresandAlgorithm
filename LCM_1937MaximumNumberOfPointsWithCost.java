import java.util.*;

class LCM_1937MaximumNumberOfPointsWithCost {
    public static long maxPoints(int[][] points) {
        long result = 0;
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[j] += points[i][j];
            }
            for(int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for(int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for(int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(LCM_1937MaximumNumberOfPointsWithCost.maxPoints(points));

        int[][] points1 = {{1,5},{2,3},{4,2}};
        System.out.println(LCM_1937MaximumNumberOfPointsWithCost.maxPoints(points1));
    }
}