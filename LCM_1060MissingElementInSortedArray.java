class LCM_1060MissingElementInSortedArray {
    public static int missingElement(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int missingNum = nums[n - 1] - nums[0] + 1 - n;
        
        if (missingNum < k) {
            return nums[n - 1] + k - missingNum;
        }
        
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            int missing = nums[mid] - nums[low] - (mid - low);
            
            if (missing >= k) {
			    // when the number is larger than k, then the index won't be located in (m, h]
                high = mid;
            } else {
			    // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
                k -= missing;
                low = mid;
            }
        }
        
        return nums[low] + k;
    }
    public static void main(String[] args) {
        int[] nums = {4, 7, 9, 10};
        int k = 1;
        System.out.println(missingElement(nums, k));
    }
}
/*
TC: log(n)
SC: O(1)
*/