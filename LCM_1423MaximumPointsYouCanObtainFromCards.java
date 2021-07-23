class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;

        for (int i = 1; i <= k; i++) {
            int right = cardPoints[cardPoints.length - i];
            int left = cardPoints[k - i];
            sum = sum + right - left;
            max = Math.max(sum, max);
        }
        return max;
    }
}

// Time O(n)