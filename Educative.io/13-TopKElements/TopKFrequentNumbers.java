import java.util.*;

class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num, 0) +1); 
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>();

        while(!minHeap.isEmpty()){
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }// TC(N Log K), SC O(N)

    public static int[] topKFrequent(int[] numbers, int k) { //Bucket Sort
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) map.put(
            number, map.getOrDefault(number, 0) + 1
        );

        int size = map.size();
        int[] keys = new int[size];
        int i = 0;
        for (int key : map.keySet()) keys[i++] = key;

        select(keys, map, 0, size - 1, size - k);
        return Arrays.copyOfRange(keys, size - k, size);
    } //TC O(N), SC O(N)

    private static void select(int[] keys, Map<Integer, Integer> map, int left, int right, int kSmallest) {
        while (left != right) {
            int pivot = partition(keys, map, left, right, (left + right) / 2);

            if (kSmallest == pivot) return;

            if (kSmallest < pivot) right = pivot - 1; 
            else left = pivot + 1;
        }
    }
        private static int partition(int[] keys, Map<Integer, Integer> map, int left, int right, int pivot) {
            int pivotValue = map.get(keys[pivot]);
            swap(keys, pivot, right);
            int index = left;
    
            for (int i = left; i <= right; i++) if (map.get(keys[i]) < pivotValue) {
                swap(keys, i, index);
                index++;
            }
            swap(keys, right, index);
            return index;
        }

        private static void swap(int[] array, int i1, int i2) {
            int temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}