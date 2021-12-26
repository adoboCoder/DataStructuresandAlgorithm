class LCM_983MinimumCostForTickets {
    public static int minCostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDay  = new boolean[lastDay + 1];

        for(int day : days) {
            isTravelDay[day] = true; // mark []isTravel to true according to input []days
        }

        for(int i = 1; i <= lastDay; i++) {
            if(!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = costs[0] + dp[i - 1]; // 1 day pass
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]); // 7 day pass
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]); // 30 day pass
        }
        return dp[lastDay];
    }
    public static void main(String[] args) {
        System.out.println(LCM_983MinimumCostForTickets.minCostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        System.out.println(LCM_983MinimumCostForTickets.minCostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2, 7, 15}));
    }
}