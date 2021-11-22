import java.util.*;

public class BlendGenerateTimeSeries {
    public static Map<Integer, Integer> getTimeSeries(int[][] loans) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(loans, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] loan : loans) {
            if(!pq.isEmpty() && pq.peek() <= loan[0]) {
                int end = pq.poll();
                map.put(end, pq.size());
            }
            pq.offer(loan[1]);
            map.put(loan[0], pq.size());
        }
        while(!pq.isEmpty()) {
            int end = pq.poll();
            map.put(end, pq.size());
        }
        return map;
    }
    public static void main(String[] args) {
    int[][] loans = {{1,9}, {3,10}, {2,6},{7, 999999999}};
    System.out.println(getTimeSeries(loans));
    }

}