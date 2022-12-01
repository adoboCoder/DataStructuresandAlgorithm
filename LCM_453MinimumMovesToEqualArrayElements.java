class LCM_453MinimumMovesToEqualArrayElements {
    public static int minMoves(int[] nums) {
        if (nums.length == 0)
            return 0;

        int min = nums[0];
        int result = 0;
        for (int n : nums)
            min = Math.min(min, n);
        for (int n : nums)
            result += n - min;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(LCM_453MinimumMovesToEqualArrayElements.minMoves(nums));
        int[] nums1 = { 1, 1, 1 };
        System.out.println(LCM_453MinimumMovesToEqualArrayElements.minMoves(nums1));
    }
}