package Blind75.Interval;
import java.util.*;
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for(int[] interval : intervals) {
            if(newInterval[1] < interval[0]) {
                result.add(newInterval);
                newInterval = interval;
            }
            else if(newInterval[0] > interval[1]) {
                result.add(interval);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {1, 5};
        System.out.println(Arrays.deepToString(InsertInterval.insert(intervals, newInterval)));
    }
}
