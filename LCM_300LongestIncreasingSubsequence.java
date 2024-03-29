class LCM_300LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;

        for (int num : nums) {
            int start = 0;
            int end = size;

            while (start != end) {
                int mid = start + (end - start) / 2;

                if (tails[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            tails[start] = num;
            if (start == size)
                size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(LCM_300LongestIncreasingSubsequence.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
        System.out.println(LCM_300LongestIncreasingSubsequence.lengthOfLIS(new int[] {0,1,0,3,2,3 }));
        System.out.println(LCM_300LongestIncreasingSubsequence.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
        System.out.println(LCM_300LongestIncreasingSubsequence.lengthOfLIS(new int[] {4,2,3,6,10,1,12}));
        System.out.println(LCM_300LongestIncreasingSubsequence.lengthOfLIS(new int[] {-4,10,3,7,15}));
    }
}