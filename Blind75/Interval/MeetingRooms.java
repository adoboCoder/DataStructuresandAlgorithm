package Blind75.Interval;
import java.util.*;

public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(MeetingRooms.canAttendMeetings(intervals));
        int[][] intervals1 = {{7, 10}, {2, 4}};
        System.out.println(MeetingRooms.canAttendMeetings(intervals1));
    }
}
