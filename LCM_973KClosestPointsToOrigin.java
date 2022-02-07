import java.util.*;

class LCM_973KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
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

    private static int helper(int[][] A, int left, int right) {
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

    private static int compare(int[] p1, int[] p2) {
        int ans = p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
        return ans;
    }
    public static void main(String[] args) {
        int[][] points = {{1, 3},{-2, 2}};
        System.out.println(Arrays.deepToString(LCM_973KClosestPointsToOrigin.kClosest(points, 1)));

        int[][] points2 = {{3, 3},{5, -1},{-2, 4}};
        System.out.println(Arrays.deepToString(LCM_973KClosestPointsToOrigin.kClosest(points2, 2)));
    }


    public int[][] kClosest_comparator(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
}