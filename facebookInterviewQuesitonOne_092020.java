
import java.io.*;
import java.util.Arrays;

public class facebookInterviewQuesitonOne_092020 {
  public static double[] findAverages(int k, int[] arr) {
    double[] result = new double[arr.length - k + 1];
    int i = 0;
    int j = 0;
    int sum = 0;

    for (j = 0; j < arr.length; j++) {
      sum = sum + arr[j];
      if (j >= k - 1) { // increasing the right pointer until we get the size of K
        sum = sum - i;
        result[i] = (double)sum / k;
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int n = 4;
    double[] out = findAverages(n, arr);
    System.out.println(Arrays.toString(out));
  }
}