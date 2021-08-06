
/*
Implement a function to bucket a histogram given a list of data 

Example input: 3,2,1,6,8,3,11 
width: 5
Example output: 
[0,5] -> 4 
[5,10] -> 2 
[10,15] -> 1 

*/

import java.util.*;

class QualtricsPhoneScreen5 {
    public static Map<Integer, Integer> bucketHistogram(int[] histogram, int width) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < histogram.length; i++) {
            max = Math.max(max, histogram[i]);
        }

        for (int i = 0; i <= max; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < histogram.length; i++) {
            map.put(i * width, map.get(i * width) + 1);
        }
        return map;
    
    }

    public static void main(String[] args) {
        int[] histogram = {3,2,1,6,8,3,11};
        int width = 5;
        Map<Integer, Integer> map = bucketHistogram(histogram, width);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
    }
}