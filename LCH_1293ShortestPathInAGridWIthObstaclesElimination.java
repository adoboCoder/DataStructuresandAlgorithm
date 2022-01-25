import java.util.*;
class LCH_1293ShortestPathInAGridWIthObstaclesElimination {
    public static int[] dirs = {0, 1, 0, -1, 0};
    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(k >= m + n - 2) return m + n - 2; 

        boolean[][][] visited = new boolean [m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, k, 0}); // row, col, k, dist
        visited[0][0][k] = true;

        while(!q.isEmpty()) {
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            int currentK = top[2];
            int dist = top[3];
            if(r == m - 1 && c == n -1) return dist;
            for(int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];
                if(nr < 0 || nr == m || nc < 0 || nc == n) continue; //skip oob cells
                int newK = currentK - grid[nr][nc];
                if(newK >= 0 && !visited[nr][nc][newK]){
                    visited[nr][nc][newK] = true;
                    q.offer(new int[] {nr, nc, newK, dist + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        System.out.println(LCH_1293ShortestPathInAGridWIthObstaclesElimination.shortestPath(grid, 1));
    }
}

// Time Complexity: O(N⋅K) - N is the number of cells in the grid, K is the number of obstacles
// Space Complexity: O(N⋅K) - N is the number of cells in the grid, K is the number of obstacles