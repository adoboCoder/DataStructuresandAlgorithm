import java.util.*;

class LCH_317ShortestDistanceFromAllBuildings {
    public static int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        } 

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dist = new int [rows][cols];
        int[][] reach = new int [rows][cols];
        int totalBuildings = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, reach, dist);
                    totalBuildings++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    minDistance = Math.min(minDistance, dist[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }


    private static void bfs(int[][] grid, int row, int col, int[][] reach, int[][] dist) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        boolean [][] visited = new boolean[rows][cols];
        visited[row][col] = true;

        int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        int distance = 0;

        while(!queue.isEmpty()) {
            distance++;

            for(int count = queue.size(); count > 0; count--){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for(int[] dir : dirs){
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if(!isValid(grid, nextX, nextY, visited)){
                        continue;
                    }

                    queue.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    reach[nextX][nextY]++;
                    dist[nextX][nextY] += distance;

                }
            }
        }

    }
    private static boolean isValid(int[][]grid, int row, int col, boolean[][] visited){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 0;

    }

    public static void main(String[] args) {
        int[][] grid = { 
                        {1, 0, 2, 0, 1},
                        {0, 0, 0, 0, 0},    
                        {0, 0, 1, 0, 0}
        };
        System.out.println(LCH_317ShortestDistanceFromAllBuildings.shortestDistance(grid));
    }
}