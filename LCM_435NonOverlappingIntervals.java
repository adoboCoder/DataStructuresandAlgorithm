import java.util.*;

class LCM_435NonOverlappingIntervals {
    public static int eraseOverlappingIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int k = 0;
        int count = 1;
        int n = intervals.length;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= intervals[k][1]){
                k = i;
                count++;
            }
        }
        return n - count;
    }
    public static void main(String[] args) {
        int[][] interval = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(LCM_435NonOverlappingIntervals.eraseOverlappingIntervals(interval));
        int[][] interval1 = {{1,2},{1,2},{1,2}};
        System.out.println(LCM_435NonOverlappingIntervals.eraseOverlappingIntervals(interval1));
        int[][] interval2 = {{1,2},{2,3}};
        System.out.println(LCM_435NonOverlappingIntervals.eraseOverlappingIntervals(interval2));
    }
}