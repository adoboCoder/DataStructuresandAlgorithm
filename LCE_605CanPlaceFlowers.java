class LCE_605CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerBed, int n) {
        int count = 0;
        for (int i = 0; i < flowerBed.length; i++) {
            int prevPlot = (i == 0 || flowerBed[i - 1] == 0) ? 0 : 1;
            int nextPlot = (i == flowerBed.length - 1 || flowerBed[i + 1] == 0) ? 0 : 1;

            if (nextPlot == 0 && prevPlot == 0) {
                flowerBed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
    }
}