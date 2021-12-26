import java.util.*;

class LCH_1610MaximumNumberOfVisiblePoints {
    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for(List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if(dx == 0 && dy == 0) {
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 * Math.PI));
        }
        Collections.sort(angles);
        List<Double> temp = new ArrayList<>();
        for(double d : angles) {
            temp.add(d + 360);
        }
        int result = count;

        for(int i = 0, j = 0; i  < temp.size(); i++) {
            while(temp.get(i) - temp.get(j) > angle) {
                j++;
            }
            result = Math.max(result, count + i - j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(1);
        p1.add(2);
        points.add(p1);
        List<Integer> p2 = new ArrayList<>();
        p2.add(2);
        p2.add(2);
        points.add(p2);
        List<Integer> p3 = new ArrayList<>();
        p3.add(3);
        p3.add(3);
        points.add(p3);
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(LCH_1610MaximumNuberOfVisiblePoints.visiblePoints(points, 90, location));

        List<List<Integer>> points1 = new ArrayList<>();
        List<Integer> pp1 = new ArrayList<>();
        pp1.add(1);
        pp1.add(0);
        points1.add(pp1);
        List<Integer> pp2 = new ArrayList<>();
        pp2.add(2);
        pp2.add(1);
        points1.add(p2);
        List<Integer> location1 = new ArrayList<>();
        location1.add(1);
        location1.add(1);
        System.out.println(LCH_1610MaximumNuberOfVisiblePoints.visiblePoints(points1, 13, location1));
    }
}