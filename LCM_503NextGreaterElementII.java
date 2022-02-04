import java.util.*;

class LCM_503NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n)
                stack.push(i);
        }
        return next;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 1})));
    }
}