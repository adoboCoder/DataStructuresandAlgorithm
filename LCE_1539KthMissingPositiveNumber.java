class LCE_1539KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k)
                r = mid; // missed more or equal than k numbers, left side;
            else
                l = mid + 1; // missed less than k numbers, must be in the right side;
        }
        return l + k;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(LCE_1539KthMissingPositiveNumber.findKthPositive(nums, k));

    }
}