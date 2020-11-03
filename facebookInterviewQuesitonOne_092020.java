import java.io.*; 
import java.util.*;

// public class facebookInterviewQuesitonOne_092020{
//     public static double[] FindMovingAverage(int[] arr, int n){
//         double [] result = new double[n];
//         for(int i = 0; i < arr.length - n; i++){
//             double currentSum = 0.0;
//           for(int j = 0; j < arr.length; j++){
//               currentSum = currentSum + arr[i + j];
//               result[i] = currentSum / n;
//           }
//         }
//         return result;
//     }

    public static void main(String[] args){
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        //int n = 4;
        //double [] out = FindMovingAverage(arr, n);
        for(int i = 0; i < arr.length; i++){
            System.out.println("[" + arr[i] +"]");
        }
        
    }
//}