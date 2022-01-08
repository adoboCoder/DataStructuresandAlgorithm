import java.util.*;

class LCM_2007FindOriginalArrayFromDoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        int[] result = new int[len / 2];
        int index = 0;
        int j = len - 1;
        
        if(len % 2 != 0) return new int[0];
        
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        
        while(j >= 0) {
            int element = changed[j];
            int doubleElement = element * 2;
            
            if(map.containsKey(doubleElement)) {
                if(map.get(doubleElement) == 1) map.remove(doubleElement);
                else map.put(doubleElement, map.get(doubleElement) - 1);
                result[index++] = element;
            }
            else {
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
            j--;
        }
        return index == len / 2 ? result : new int[] {};
    }

    public static void main(String[] args) {
        int[] input = {1,3,4,2,6,8};
        System.out.println(Arrays.toString(LCM_2007FindOriginalArrayFromDoubledArray.findOriginalArray(input)));
        input = new int[] {6, 3, 0, 1};
        System.out.println(Arrays.toString(LCM_2007FindOriginalArrayFromDoubledArray.findOriginalArray(input)));

    }
}