import java.util.*;
class LCM_56MergeIntervals {
	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		// Sort by ascending starting point
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();
        //NewInterval is the first item in intervals[]
		int[] newInterval = intervals[0];
        // Add first item to results set to start comparing.
        result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } // Overlapping intervals, move the end if needed
                
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] input = { { 0, 3 }, { 2, 4 }, { 1, 3} };
		int[][] output = LCM_56MergeIntervals.merge(input);

		System.out.println(Arrays.deepToString(output));

	}
}