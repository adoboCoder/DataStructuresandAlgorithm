import java.util.*;

class LCM_994RottingOranges {
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        if(fresh == 0) return 0;
        int count = 0;
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()) {
            count++;
            int level = queue.size();
            
            for(int i = 0; i < level; i++) {
                int[] point = queue.poll();
                for(int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? count - 1 : -1;
    }
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(LCM_994RottingOranges.orangesRotting(grid1));
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(LCM_994RottingOranges.orangesRotting(grid2));
    }
}