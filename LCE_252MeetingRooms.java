import java.util.*;
class LCE_252MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10},{15,20}};
        System.out.println(LCE_252MeetingRooms.canAttendMeetings(intervals));
        int[][] intervals1 = {{7,10},{2,4}};
        System.out.println(LCE_252MeetingRooms.canAttendMeetings(intervals1));
    }
}