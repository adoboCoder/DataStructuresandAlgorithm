import java.util.*;

class LCM_347TopKFrequentElements {
    public static  int[] topKFrequent(int[] nums, int k) {
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
            
        int[] result = new int[topNumbers.size()];
        
        for(int i = 0; i < topNumbers.size(); i++){
            result[i] = topNumbers.get(i);
        }
            
        return result;
    }

    
  public static void main(String[] args) {
    int[] result = LCM_347TopKFrequentElements.topKFrequent(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = LCM_347TopKFrequentElements.topKFrequent(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}