import java.util.*;

class LCM_2128RemoveAllOnesWIthRowAndColumnFlips {
    public static boolean removeOnes(int[][] grid) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder reversedSb = new StringBuilder();

        for(int i = 0; i < grid[0].length; i++) {
            sb.append(grid[0][i]);
            reversedSb.append(grid[0][i] == 0 ? 1 : 0);
        }

        set.add(sb.toString());
        set.add(reversedSb.toString());

        for(int j = 1; j < grid.length; j++) {
            sb = new StringBuilder();
            reversedSb = new StringBuilder();
            for(int i = 0; i < grid[j].length; i++) {
                sb.append(grid[j][i]);
                reversedSb.append(grid[j][i] == 0 ? 1 : 0);
            }
            if(!set.contains(sb.toString()) || !set.contains(reversedSb.toString())) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] grid =  {
                            {0,1,0},
                            {1,0,1},
                            {0,1,0}
                        };
        System.out.println(LCM_2128RemoveAllOnesWIthRowAndColumnFlips.removeOnes(grid));

        int[][] grid2 =  {
            {1,1,0},
            {0,0,0},
            {0,0,0}
        };
        System.out.println(LCM_2128RemoveAllOnesWIthRowAndColumnFlips.removeOnes(grid2));
    }
}