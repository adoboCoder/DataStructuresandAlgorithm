import java.util.PriorityQueue;

class LCE_1046LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n : stones) {
            maxHeap.offer(n);
        }
        while(maxHeap.size() > 1) {
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}