import java.util.*;

class LCM_347TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        int[] result = new int[topNumbers.size()];

        for (int i = 0; i < topNumbers.size(); i++) {
            result[i] = topNumbers.get(i);
        }

        return result;
    }

    public static List<Integer> topKFrequent_bucketSort(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = LCM_347TopKFrequentElements.topKFrequent(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + Arrays.toString(result));

        int[] result1 = LCM_347TopKFrequentElements.topKFrequent(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + Arrays.toString(result1));

        int[] result2 = LCM_347TopKFrequentElements.topKFrequent(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result2);

        List<Integer> result3 = new ArrayList<>();
        result3 = LCM_347TopKFrequentElements.topKFrequent_bucketSort(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result3);
        
    }
}

// Heap Solution
// TC: O(n Log K)
// SC: O(N + k)

// Quick Sort Solution
// TC: O(n) on average, O(n^2) at worst case
// SC: O(N)