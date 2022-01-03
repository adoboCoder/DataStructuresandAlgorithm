import java.util.*;

class LCM_447NumberOfBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int k : map.values()) {
                result += k * (k - 1);
            }
            map.clear();
        }
        return result;
    }

    private static int getDistance(int[] p, int[] q) {
        int a = p[0] - q[0];
        int b = p[1] - q[1];
        return a * a + b * b;
    }

    public static void main(String[] args) {
        int[][] points = {
                { 1, 1 },
                { 2, 2 },
                { 3, 3 }
        };
        System.out.println(LCM_447NumberOfBoomerangs.numberOfBoomerangs(points));
    }
}