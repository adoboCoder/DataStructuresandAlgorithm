class LCM_1891CuttingRibbons {
    public static int maxLength(int[] ribbons, int k) {
        int left = 0;
        int right = 100_000;
        while (left < right) {
            int numRibbons = 0;
            int currLength = left + (right - left) / 2 + 1;
            for (int i = 0; i < ribbons.length && numRibbons < k; ++i) {
                numRibbons += ribbons[i] / currLength;
            }
            if (numRibbons >= k) {
                left = currLength;
            } else {
                right = currLength - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ribbons = { 9, 7, 5 };
        int k = 3;
        System.out.println(LCM_1891CuttingRibbons.maxLength(ribbons, k));
    }
}