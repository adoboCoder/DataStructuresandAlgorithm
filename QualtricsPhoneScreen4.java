import java.util.*;

class QualtricsPhoneScreen4 {
    private static boolean solution(double[][] points, int start_idx, int end_idx, int j) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start_idx);
        visited.add(start_idx);
        while (!q.isEmpty()) {
            int idx = q.remove();
            if (getDistance(points[idx], points[end_idx]) <= j) {
                return true;
            }
            for (int i = 0; i < points.length; i++) {
                if (i != end_idx && !visited.contains(i) && getDistance(points[idx], points[i]) <= j) {
                    q.add(i);
                    visited.add(i);
                }
            }
        }

        return false;
    }

    private static double getDistance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2));
    }

    public static void main(String[] args) {
        System.out.println(QualtricsPhoneScreen4.solution(new double[][] {{1, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {3, 4}, {4, 2}, {4, 1}, {5, 1}, {5, 0}}, 0, 9, 1));
        System.out.println(QualtricsPhoneScreen4.solution(new double[][] {{1, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {3, 4}, {4, 1}, {5, 1}, {5, 0}}, 0, 8, 1));
    }
}