import java.util.*;

class KaratxWayfairInterview {
    public static List<String> findContiguousHistory(String[] array1, String[] array2) {

        String[] longArray = array1;
        String[] shortArray = array2;

        if (array1.length < array2.length) {
            shortArray = array1;
            longArray = array2;
        } else {
            shortArray = array2;
            longArray = array1;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < longArray.length; i++) {
            map.put(longArray[i], i);
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < shortArray.length; i++) {
            List<String> curr = new ArrayList<>();
            String str = shortArray[i];
            if (map.containsKey(str)) {
                int index = map.get(str);
                int k = i;
                while (index < longArray.length && k < shortArray.length) {
                    if (longArray[index].equalsIgnoreCase(shortArray[k])) {
                        curr.add(shortArray[k]);
                    } else
                        break;
                    index++;
                    k++;
                }
                if (result.size() < curr.size()) {
                    result = curr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] user1 = { "hi", "bye", "hello", "leetcode", "start", "end" };
        String[] user2 = { "hi", "stop", "leetcode", "start", "end", "bye" };

        System.out.println(KaratxWayfairInterview.findContiguousHistory(user1, user2));
    }
}