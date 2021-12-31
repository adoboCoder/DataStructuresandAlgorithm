class LCM_1011CapacityToShipWithinDDays {
    public static int shipWithinDDays (int[] weights, int D) {
        int min = 0;
        int max = 0;

        for(int w : weights) {
            min = Math.min(min, w);
            max = max + w;
        }

        int result = 0;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            int daysRequired = numberOfDaysNeededWithCapacity(weights, mid);

            if(daysRequired > D) {
                min = mid + 1;
            }
            else {
                result = mid;
                max = mid - 1;
            }
        }
        return result;
    }
    private static int numberOfDaysNeededWithCapacity(int [] weights, int capacity) {
        int daysRequired = 1;
        int currentWeight = 0;

        for(int w : weights) {
            currentWeight = currentWeight + w;
            if(currentWeight > capacity) {
                daysRequired++;
                currentWeight = w;
            }
        }
        return daysRequired;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDDays(weights, days));

        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDDays(weights2, days2));

        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println(LCM_1011CapacityToShipWithinDDays.shipWithinDDays(weights3, days3));
    }

}