import java.util.*;

class LCH_1610MaximumNuberOfVisiblePoints {
        public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            List<Double> angles = new ArrayList<>();
            int count = 0;
            
            for(List<Integer> p : points) {
                int dx = p.get(0) - location.get(0);
                int dy = p.get(1) - location.get(1);
                if(dy == 0 && dx == 0) {
                    count++;
                    continue;
                }
                else {
                    angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
                }
            }
            Collections.sort(angles);
            List<Double> tmp = new ArrayList<>(angles);
            for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
            int res = count;
            for (int i = 0, j = 0; i < tmp.size(); i++) {
                while (tmp.get(i) - tmp.get(j) > angle) {
                    j++;
                }
                res = Math.max(res, count + i - j + 1);
            }
            return res;
        }
    
    public static void main(String[] args) {
        List<Integer> p1 = new ArrayList<>();
        p1.add(2);
        p1.add(1);
        List<Integer> p2 = new ArrayList<>();
        p2.add(2);
        p2.add(2);
        List<Integer> p3 = new ArrayList<>();
        p3.add(3);
        p3.add(3);

        List<List<Integer>> input = new ArrayList<>();
        input.add(p1);
        input.add(p2);
        input.add(p3);

        int angle = 90;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        System.out.println(LCH_1610MaximumNuberOfVisiblePoints.visiblePoints(input, angle, location));
    }
}