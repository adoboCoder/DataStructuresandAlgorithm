import java.util.*;

class AverageWindow {
    public static double[] findAverage(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        int i = 0;
        int j = 0;
        int sum = 0;

        for (j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            if (j >= k - 1) { // increasing the right pointer until we get the size of K
                sum = sum - i; // move left pointer by subracting i from sum
                result[i] = (double)sum / k;
                i++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = 4;
        double[] out = findAverage(arr, n);
        System.out.println(Arrays.toString(out));
    }
}
