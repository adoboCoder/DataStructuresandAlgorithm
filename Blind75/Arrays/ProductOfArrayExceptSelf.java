package Blind75.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf  {
    public static int[] find(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        int right = 1;

        for(int i = 0; i < nums.length; i++) {
            if(i > 0) {
                left = left * nums[i - 1];
            }
            result[i] = left;
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i < nums.length -1) {
                right = right * nums[i + 1];
            }
            result[i] = result[i] * right;
        }
        return result; 
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ProductOfArrayExceptSelf.find(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(ProductOfArrayExceptSelf.find(new int[] {-1,1,0,-3,3})));
    }
}
