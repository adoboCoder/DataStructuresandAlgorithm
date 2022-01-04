import java.util.*;

class LCM_1218LongestArithmeticSubSequenceOfGivenDifference {
    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>(); // K: value at index , V: value - diff
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            result = Math.max(result, map.get(arr[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int diff = 1;
        System.out.println(LCM_1218LongestArithmeticSubSequenceOfGivenDifference.longestSubsequence(arr, diff));

        int[] arr2 = {1, 3, 5, 7};
        int diff2 = 1;
        System.out.println(LCM_1218LongestArithmeticSubSequenceOfGivenDifference.longestSubsequence(arr2, diff2));

        int[] arr3 = {1,5,7,8,5,3,4,2,1};
        int diff3 = -2;
        System.out.println(LCM_1218LongestArithmeticSubSequenceOfGivenDifference.longestSubsequence(arr3, diff3));
    }
}