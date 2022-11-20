import java.util.*;

class Solution {
    private int[] prefixSum;
    private int sum;

    public Solution(int[] w) {
        sum = 0;
        prefixSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum = sum + w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        int left = 0;
        int right = prefixSum.length - 1;
        double rand = (new Random().nextDouble()) * sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (rand > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }
}

// TC : Constructor O(N), pickindex O(logN)
// SC : Constructor O(N), pickindex O(1)