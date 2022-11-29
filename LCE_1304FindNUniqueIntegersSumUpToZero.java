import java.util.*;

class LCE_1304FindNUniqueIntegersSumUpToZero {
    public static int[] findSumZero(int n) {
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int start = 1;

        while (left < right) {
            result[left++] = start;
            result[right--] = -start;
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(LCE_1304FindNUniqueIntegersSumUpToZero.findSumZero(n)));
        n = 7;
        System.out.println(Arrays.toString(LCE_1304FindNUniqueIntegersSumUpToZero.findSumZero(n)));
    }
}