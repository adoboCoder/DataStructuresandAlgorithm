class LCM_875KokoEatingBananas {
    public static int minEatingSpeed (int[] piles, int H) {
        int low = 1;
        int high = getMax(piles);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canEatAllBananas(piles, mid, H)) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private static int getMax(int[] piles) {
        int result = -1;
        for(int p : piles) {
            result = Math.max(p, result);
        }
        return result;
    }

    private static boolean canEatAllBananas(int[] piles, int mid, int H) {
        int countHour = 0;

        for(int p : piles) {
            countHour = countHour + (p / mid);
            if(p % mid != 0)  {
                countHour++;
            }
        }
        return countHour <= H;
    }
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(LCM_875KokoEatingBananas.minEatingSpeed(piles, h));

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(LCM_875KokoEatingBananas.minEatingSpeed(piles2, h2));
        
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(LCM_875KokoEatingBananas.minEatingSpeed(piles3, h3));
    }
}