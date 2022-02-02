import java.util.*;

class LCM_934ShortestBridge {
    public static int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for(int i = 0; i < m; i++) {
            if(found) {
                break;
            }
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j, dirs);
                    found = true;
                    break;
                }
            }
        }
        int result = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (grid[i][j] == 1) {
                            return result;
                        }
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private static void dfs(int[][] grid, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
        if(i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == 0) return;
        visited[i][j] = true;
        q.offer(new int[] {i, j});
        for(int[] dir : dirs) {
            dfs(grid, visited, q, i + dir[0], j + dir[1], dirs);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge(grid));
    }
}