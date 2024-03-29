import java.util.*;

class LCM_200NumberOfIslands {
    private static int n;
    private static int m;

    public static int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i, j + 1);
        sinkIsland(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '1', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(LCM_200NumberOfIslands.numIslands(grid));
    }
}