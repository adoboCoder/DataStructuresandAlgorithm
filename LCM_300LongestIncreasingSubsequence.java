class LCM_300LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;

        for (int num : nums) {
            int start = 0;
            int end = size;

            while (start != end) {
                int mid = (start + end) / 2;

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
    }
}