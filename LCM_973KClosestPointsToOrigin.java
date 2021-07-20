import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
    int len =  points.length;
    int    left = 0;
    int    right = len - 1;
    while (left <= right) {
        int mid = helper(points, left, right);
        if (mid == K) break;
        if (mid < K) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return Arrays.copyOfRange(points, 0, K);
}

    private int helper(int[][] A, int left, int right) {
        int[] pivot = A[left];
        while (left < right) {
            while (left < right && compare(A[right], pivot) >= 0){
                right--;
            } 
            A[left] = A[right];
            while (left < right && compare(A[left], pivot) <= 0){
                left++;
            } 
            A[right] = A[left];
        }
        A[left] = pivot;
        return left;
    }

    private int compare(int[] p1, int[] p2) {
        int ans = p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
        return ans;
    }
}