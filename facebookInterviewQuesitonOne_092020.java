
import java.io.*; 

public class facebookInterviewQuesitonOne_092020{
    public static double[] FindMovingAverage(int[] arr, int n){
        double [] result = new double[n];
        int start = 0;
        int end = n - 1;
        for(int i = 0; i < arr.length - n + 1; i++){
            double currentSum = 0.0;
          for(int j = 0; j < arr.length; j++){
              currentSum = currentSum + arr[i + j];
              result[i] = currentSum / n;
          }
        }
        return result;
    }

    public static void main(String[] args){
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 4;
        double [] out = FindMovingAverage(arr, n);
        for(double d : out){
            System.out.println("[" + d +"]");
        }
        System.out.println(FindMovingAverage(arr, n));
    }
}