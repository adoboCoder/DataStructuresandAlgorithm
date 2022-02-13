class LCM_1094CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        // Because from and to is between 0 and 1000. Idea is to store counts in an array of size 1001.
        int lengthOfTrip[] = new int[1001];
        for (int trip[] : trips){
            lengthOfTrip[trip[1]] += trip[0]; // Increment when passenger is on board
            lengthOfTrip[trip[2]] -= trip[0]; // decrement when they depart
        }
		// Count total passenger for each bus top
        int carLoad = 0;
        // we have the count array, we perform a line sweep from 0 to 1000 and track its total
        for (int i = 0; i < 1001; i++){
            carLoad += lengthOfTrip[i];
			// Reject when the car is overloaded somewhere
            if(carLoad > capacity) return false;
        }

        return true; // Accept only if all trip is safe
    }
    public static void main(String[] args) {
        int[][] trips = {
            {2,1,5},
            {3,3,7}
        };
        int capacity = 4;
        int capacity2 = 5;

        System.out.println(carPooling(trips, capacity));
        System.out.println(carPooling(trips, capacity2));
    }
}
/*
Time Complexity :- BigO(n), where n is the number of trips.
Space Complexity :- BigO(max(n, 1001))
*/