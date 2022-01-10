class LCE_26RemoveDupicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if(i == 0 || n > nums[i - 1])
                nums[i++] = n;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(LCE_26RemoveDupicatesFromSortedArray.removeDuplicates(nums));
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(LCE_26RemoveDupicatesFromSortedArray.removeDuplicates(nums1));
    }
}