class LCM_33SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int minIndex = binarySearch(nums);

        if (target == nums[minIndex])
            return minIndex;

        int m = nums.length;

        int start = (target <= nums[m - 1]) ? minIndex : 0;
        int end = (target > nums[m - 1]) ? minIndex : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}