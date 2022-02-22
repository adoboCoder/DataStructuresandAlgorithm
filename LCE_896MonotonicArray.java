class LCE_896MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        int inc = 1;
        int dec = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > 0)
                inc++;
            else if(nums[i] - nums[i - 1] < 0)
                dec++;
            else {
                inc++;
                dec++;
            }
        }
        return inc == nums.length || dec == nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int[] nums2 = {6,5,4,4};
        int[] nums3 = {1,3,2};

        System.out.println(isMonotonic(nums));
        System.out.println(isMonotonic(nums2));
        System.out.println(isMonotonic(nums3));

    }
}
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/