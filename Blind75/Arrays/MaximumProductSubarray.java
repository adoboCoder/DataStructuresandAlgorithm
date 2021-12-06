package Blind75.Arrays;

public class MaximumProductSubarray {
    public static int findMaxProductSubarray(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        int answer = nums[0];

        for(int i = 0; i < n; i++) {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left = left * nums[i];
            right = right * nums[n - 1 - i];
            answer = Math.max(answer, Math.max(left, right));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(MaximumProductSubarray.findMaxProductSubarray(new int[] {2,3,-2,4}));
        System.out.println(MaximumProductSubarray.findMaxProductSubarray(new int[] {-2,0,-1}));
    }
}
