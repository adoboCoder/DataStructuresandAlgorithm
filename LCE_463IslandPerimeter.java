class LCE463IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;
        if(grid[i][j] == -1) return 0;
        if(grid[i][j] == 0) return 1;

        int count = 0;
        grid[i][j] = -1;

        count+=dfs(grid, i + 1, j);
        count+=dfs(grid, i, j + 1);
        count+=dfs(grid, i - 1, j);
        count+=dfs(grid, i, j - 1);
        return count;
    }

    public static void main(String[] args) {
        int[][] arr =   {   
                            {0,1,0,0},
                            {1,1,1,0},
                            {0,1,0,0},
                            {1,1,0,0}
                        };
        System.out.println(LCE463IslandPerimeter.islandPerimeter(arr));
    }
}
