class LCM_1007MinimumDominoRotationsForEqualRow {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int minSwaps = Math.min(
            numSwaps(tops[0], tops, bottoms),
            numSwaps(bottoms[0], tops, bottoms)
        );

        minSwaps = Math.min(minSwaps, numSwaps(tops[0], bottoms, tops));
        minSwaps = Math.min(minSwaps, numSwaps(bottoms[0], bottoms, tops));

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
    private static int numSwaps(int target, int[] A, int[]B) {
        int result = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] != target && B[i] != target) {
                return Integer.MAX_VALUE;
            }
            else if(A[i] != target) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        System.out.println(LCM_1007MinimumDominoRotationsForEqualRow.minDominoRotations(tops, bottoms));
    }
}
