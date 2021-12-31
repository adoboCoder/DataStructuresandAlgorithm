class LCM_1011CapacityToShipWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = 0;
        for (int w : weights) {
            max += w;
            min = Math.max(min, w);
        }
        
        while (min < max) {
            int mid = (max + min) / 2;
            if (canShip(mid, weights, days)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    
    public static boolean canShip(int dailySum, int[] weights, int days) {
        int tempSum = 0;
        int shipDay = 0;
        for (int w : weights) {
            if (tempSum + w > dailySum) {
                shipDay += 1;
                
                tempSum = w; 
            } else {
                tempSum += w;
            }
        }
        if (shipDay + 1 > days) return false;
        return true;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDays(weights, days));

        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDays(weights2, days2));

        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDays(weights3, days3));
    }
}