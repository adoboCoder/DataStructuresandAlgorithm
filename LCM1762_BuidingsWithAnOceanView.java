import java.util.*;

class LCM1762_BuidingsWithAnOceanView {
    public static int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int last = Integer.MIN_VALUE;

        for(int i = heights.length -1; i >= 0; i--){ 
            if(heights[i] > last){
                last = heights[i];
                result.add(i);
            }
        }
        return toArray(result);
    }

    private static int[] toArray(List<Integer> result) {
        int[] arrResult = new int[result.size()];
        for(int i = 0; i < arrResult.length; i++) {
            arrResult[i] = result.get(arrResult.length - i - 1);
        }
        return arrResult;
    }

    public static void main(String[] args) {
        int[] heights = LCM1762_BuidingsWithAnOceanView.findBuildings(new int[] {4, 2, 3, 1});
        System.out.println(Arrays.toString(heights));

        int[] heights2 = LCM1762_BuidingsWithAnOceanView.findBuildings(new int[] {4, 3, 2, 1});
        System.out.println(Arrays.toString(heights2));

        int[] heights3 = LCM1762_BuidingsWithAnOceanView.findBuildings(new int[] {1, 3, 2, 4});
        System.out.println(Arrays.toString(heights3));
    }
}