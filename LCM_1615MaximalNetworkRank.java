class LCM_1615MaximalNetworkRank {
    public static int maxNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] counts = new int[n];

        for (int[] r : roads) {
            counts[r[0]]++;
            counts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, counts[i] + counts[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(LCM_1615MaximalNetworkRank.maxNetworkRank(n, roads));
    }
}