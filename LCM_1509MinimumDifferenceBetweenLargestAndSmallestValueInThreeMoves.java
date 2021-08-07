import java.util.*;

class LCM_1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static int minDifference(int[] nums){
        if(nums.length < 5) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(4);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(4, Collections.reverseOrder());

        for(int num : nums) {
            minHeap.add(num);
            maxHeap.add(num);

            if(maxHeap.size() > 4 || minHeap.size() > 4) {
                minHeap.poll();
                maxHeap.poll();
            }
        }

        int[] smallest = new int[4];
        int[] largest = new int[4];

        for(int i = 0; i < 4; i++) {
            smallest[3 - i] = minHeap.poll();
            largest[i] = maxHeap.poll();
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++) {
            result = Math.min(result, largest[i] - smallest[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LCM_1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.minDifference(new int[]{5, 3, 2, 4}));
        
    }
}