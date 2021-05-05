class MicrosoftPhoneScreen{
    public static boolean exist(char[][] grid, String word){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == word.charAt(0) && dfs(grid, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] grid, int i, int j, int count, String word){
        if(count == word.length()){
            return true;
        }

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != word.charAt(count)){
            return false;
        }

        char temp = grid[i][j];
        grid[i][j] = ' ';
        boolean found = dfs(grid, i + 1, j, count +1, word)
                || dfs(grid, i - 1, j, count +1, word)
                || dfs(grid, i, j + 1, count +1, word)
                || dfs(grid, i, j - 1, count +1, word)
                || dfs(grid, i + 1, j + 1, count +1, word)
                || dfs(grid, i - 1, j -1, count +1, word)
                || dfs(grid, i + 1, j - 1, count +1, word)
                || dfs(grid, i - 1, j + 1, count +1, word);

        grid[i][j] = temp;
        return found;
    }

    public static void main(String[] args){
        char[][] grid ={
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'g', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'},
            {'a', 'b', 'c', 'd', 'e', 'f'}
        };

        String s = "john";
        String b = MicrosoftPhoneScreen.exist(grid, s) == true ? "present" : "not present";
        System.out.println(s + " is " + b);

        s = "top";
        b = MicrosoftPhoneScreen.exist(grid, s) == true ? "present" : "not present";
        System.out.println(s + " is " + b);

        s = "norm";
        b = MicrosoftPhoneScreen.exist(grid, s) == true ? "present" : "not present";
        System.out.println(s + " is " + b);

    }

}