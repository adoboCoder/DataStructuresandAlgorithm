import java.util.*;

class LCH_1944NumberOfVisiblesInAQueue {
    public static int[] canSeePersonsCount(int[] A) {
        int n = A.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                result[stack.pop()]++;
            if (!stack.isEmpty())
                result[stack.peek()]++;
            stack.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 6, 8, 5, 11, 9 };
        System.out.println(Arrays.toString(canSeePersonsCount(nums)));
    }
}
/**
 * TC O(N)
 * SC O(N)
 */