import java.lang.reflect.Array;
import java.util.Arrays;

class LCM_253MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        int[] sortedStart = new int[intervals.length];
        int[] sortedEnd = new int[intervals.length];

        int n = 0;
        int result = 0;

        for (int[] interval : intervals) {
            sortedStart[n] = interval[0];
            sortedEnd[n] = interval[1];
            n++;
        }

        Arrays.sort(sortedStart);
        Arrays.sort(sortedEnd);

        n = 0;

        for (int i : sortedStart) {
            if (i < sortedEnd[n]) {
                result++;
            } else {
                n++;
            }
        }
        return result;
    }
}