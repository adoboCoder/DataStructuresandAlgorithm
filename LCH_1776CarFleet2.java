import java.util.*;

class LCH_1776CarFleet2 {
    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        Deque<Integer> stack = new LinkedList<>();
        double[] result = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            result[i] = -1.0;
            int position1 = cars[i][0];
            int speed1 = cars[i][1];
            while (stack.size() > 0) {
                int j = stack.peekLast();
                int position2 = cars[j][0];
                int speed2 = cars[j][1];
                if (speed1 <= speed2 || 1.0 * (position2 - position1) / (speed1 - speed2) >= result[j] && result[j] > 0)
                    stack.pollLast();
                else
                    break;
            }
            if (stack.size() > 0) {
                int j = stack.peekLast(), position2 = cars[j][0], speed2 = cars[j][1];
                result[i] = 1.0 * (position2 - position1) / (speed1 - speed2);
            }
            stack.add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] cars = {{1,2}, {2,1}, {4,3}, {7,2}};
        System.out.println(Arrays.toString(LCH_1776CarFleet2.getCollisionTimes(cars)));
    }
}