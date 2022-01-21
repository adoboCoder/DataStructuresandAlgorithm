class LCE_88MergeSortedArray{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int result = m + n - 1;

        while(tail1 >= 0 && tail2 >= 0) {
            nums1[result--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }

        while(tail2 >= 0) {
            nums1[result--] = nums2[tail2--];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        System.out.println(LCE_88MergeSortedArray.merge(nums1, m, nums2, n));

    }
    
}