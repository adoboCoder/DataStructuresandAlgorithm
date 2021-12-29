import java.util.*;
class DetectSquares {
    int[][] countPoints = new int[1001][1001];
    List<int[]> points = new ArrayList<>();
    
    public void add(int[] point) {
        countPoints[point[0]][point[1]] += 1;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int ans = 0;
        for(int[] p3 : points) {
            int x3 = p3[0];
            int y3 = p3[1];
            
            if(Math.abs(x1 - x3) == 0 || Math.abs(x1 - x3) != Math.abs(y1 - y3)) {
                continue;
            }
            ans = ans + countPoints[x1][y3] * countPoints[x3][y1];
        }
        
        return ans;
    }
}
