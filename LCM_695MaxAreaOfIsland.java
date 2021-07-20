class LCM_695MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,dfs(grid, i, j));  
                }
            }
        }
        return maxArea;
    }
    
    public static int dfs(int[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        }
        return 0;
    }
    public static void main(String[] args) {
        //Declare 2d matrix
        int[][] grid = {
                        {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                        };
        System.out.println(LCM_695MaxAreaOfIsland.maxAreaOfIsland(grid));
    }
}