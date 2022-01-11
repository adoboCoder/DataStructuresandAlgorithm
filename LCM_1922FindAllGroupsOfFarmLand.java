import java.util.*;

class LCM_1922FindAllGroupsOfFarmLand {
    public static int[][] findFarmLand(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && (i == 0 || land[i - 1][j] == 0) && (j == 0 || land[i][j - 1] == 0)) {
                    int i2 = i;
                    int j2 = j;

                    while (i2 < m && land[i2][j] == 1)
                        i2++;
                    while (j2 < n && land[i][j2] == 1)
                        j2++;
                    result.add(new int[] { i, j, i2 - 1, j2 - 1 });
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] land = {
                { 1, 0, 0 },
                { 0, 1, 1 },
                { 0, 1, 1 }
        };
        System.out.println(Arrays.deepToString(LCM_1922FindAllGroupsOfFarmLand.findFarmLand(land)));
    }

}