class LCM_1891CuttingRibbons {
    public static int maxLength(int[] ribbons, int k) {
        int l = 0, r = 100_000;
        while (l < r) {
            int numRibbons = 0;
            int currLength = l + (r - l) / 2 + 1;
            for (int i = 0; i < ribbons.length && numRibbons < k; ++i) {
                numRibbons += ribbons[i] / currLength;
            }
            if (numRibbons >= k) {
                l = currLength;
            } else {
                r = currLength - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] ribbons = { 9, 7, 5 };
        int k = 3;
        System.out.println(LCM_1891CuttingRibbons.maxLength(ribbons, k));
    }
}