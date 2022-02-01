class LCM_162FindPeakElement {
    public static int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (start + 1 == end) {
                return nums[start] > nums[end] ? start : end;
            }

            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        int[] nums1 = { 1, 2, 3, 1 };

        System.out.println(LCM_162FindPeakElement.findPeak(nums));
        System.out.println(LCM_162FindPeakElement.findPeak(nums1));
    }
}