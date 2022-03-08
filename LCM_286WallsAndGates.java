import java.util.*;

class LCM_286WallsAndGates {
    private static int[] d = {0, 1, 0, -1, 0};

    public static void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j);
                }
    }

    public static void dfs(int[][] rooms, int i, int j) {
        for (int k = 0; k < 4; ++k) {
            int p = i + d[k];
            int q = j + d[k + 1];
            if (0<= p && p < rooms.length && 0<= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
                rooms[p][q] = rooms[i][j] + 1;
                dfs(rooms, p, q);
            }
        }
    }
}
/*
TC: O(MN)
SC: O(MN)
 */