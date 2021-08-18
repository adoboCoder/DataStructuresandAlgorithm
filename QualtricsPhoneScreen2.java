import java.util.*;

class QualtricsPhoneScreen2 {
    public static List<String> KthMostFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if( k < 0 || words == null || words.length == 0){
            return result;
        }

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        return result;

    }

    public static void main(String[] args) {
        String[] words = {  "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", 
                            "dog", "fox", "fox", "jumps", "over", "the", "lazy", "dog","fox"
                        };
        System.out.println(QualtricsPhoneScreen2.KthMostFrequent(words, 3));
    }
}