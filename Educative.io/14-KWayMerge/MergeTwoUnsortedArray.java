import java.util.*;

class MergeTwoUnsortedArray {
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while(j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        int[] a = {12, -7, 18, 9, 37, -1, 21};
        int[] b = {27, 8, 71, -9, 18};
        System.out.println(Arrays.toString(merge(a, b)));
    }
}