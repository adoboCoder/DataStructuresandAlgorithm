class LCE_724FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (left == sum)
                return i;
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 3, 6, 5, 6 };
        System.out.println(LCE_724FindPivotIndex.pivotIndex(nums1));
        int[] nums2 = { 1, 2, 3 };
        System.out.println(LCE_724FindPivotIndex.pivotIndex(nums2));
        int[] nums3 = { 2, 1, -1 };
        System.out.println(LCE_724FindPivotIndex.pivotIndex(nums3));

    }
}