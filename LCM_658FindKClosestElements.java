import java.util.*;

class LCM_658FindKClosestElements {
    public static List<Integer> findClosestElement(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        List<Integer> result = new ArrayList<>();

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;
        System.out.println(LCM_658FindKClosestElements.findClosestElement(arr, k, x));

        System.out.println(LCM_658FindKClosestElements.findClosestElement(arr, 4, -1));
    }
}