import java.util.*;

class LCH_1499MaximumValueOfEquation {
    public static int findMaxValueOfEquation(int[][] p, int k) {
        Deque<Integer> d = new ArrayDeque<>();

        int result = Integer.MIN_VALUE;

        for(int j = 0; j < p.length; j++) {
            while(!d.isEmpty() && p[j][0] - p[d.peek()][0] > k) {
                d.poll();
            }
            if(!d.isEmpty()) {
                result = Math.max(result, p[d.peek()][1] - p[d.peek()][0] + p[j][1] + p[j][0]);
            }
            while(!d.isEmpty() && p[d.peekLast()][1] - p[d.peekLast()][0] < p[j][1] - p[j][0]) {
                d.pollLast();
            }
            d.addLast(j);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] p = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int k = 1;
        System.out.println(LCH_1499MaximumValueOfEquation.findMaxValueOfEquation(p, k));
    }
}