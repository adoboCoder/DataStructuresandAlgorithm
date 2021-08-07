import java.util.*;

class LCM1762_BuidingsWithAnOceanView {
    public static int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int last = Integer.MIN_VALUE;

        for(int i = heights.length -1; i >= 0; i--){ 
            if(heights[i] > last){
                list.add(i);
                last = heights[i];
            }
        }

        int[] result = new int[list.size()];

        int index = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            result[index] = list.get(i);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 3, 1};
        heights = LCM1762_BuidingsWithAnOceanView.findBuildings(heights);
        
            System.out.println(Arrays.toString(heights));
        
    }
}