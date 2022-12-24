import java.util.*;

class Airclub {

    public static int scheduleClass(int[][] scheduled_time_slots, int duration, int t1, int t2) {
        Arrays.sort(scheduled_time_slots, (a, b) -> a[1] - b[1]);
        for (int time = t1; time <= t2; time++) {
            boolean time_slot_found = true;
    
            for (int[] scheduled_time_slot : scheduled_time_slots) {
                int start_time = scheduled_time_slot[0];
                int end_time = scheduled_time_slot[1];
    
                // Check if the current time is within the scheduled time slot
                if (time >= start_time && time < end_time) {
                    // Time slot is being used, move on to the next time
                    time_slot_found = false;
                    break;
                }
            }
    
            if (time_slot_found) {
                // Calculate the end time of the new class
                int class_end_time = time + duration;
    
                // Check if the end time of the new class is within the requested time range
                if (class_end_time <= t2) {
                    // Return the current time as the starting time for the new class
                    return time;
                }
            }
        }
    
        // Return -1 if no time was available within the requested time range
        return -1;
    }

    public static void main(String[] args) {
        int[][] classes = { {4,9}, {12,13} };
        int duration = 2;
        int openTime = 0;
        int closeTime = 15;
        int result = Airclub.scheduleClass(classes, duration, openTime, closeTime);

        System.out.println(result);
    }

}