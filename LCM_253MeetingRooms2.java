import java.util.*;

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

    public static void main(String[] args) {
        int[][] interval = { { 0, 30 }, { 5, 10 }, { 15, 20 }, { 0, 15 } };
        System.out.println(Arrays.deepToString(interval));
        System.out.println(LCM_253MeetingRooms2.minMeetingRooms(interval));
    }
}

// TC O(N log N)
// SC O(N)