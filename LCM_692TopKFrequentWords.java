import java.util.*;

class LCM_692TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
                b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public static void main(String[] args) {
        List<String> result = LCM_692TopKFrequentWords
                .topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
        System.out.println("Here are the K frequent words:" + result);
    }
}
