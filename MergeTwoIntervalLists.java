import java.util.*;

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class myComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval i1, Interval i2) {
		if (i1.start == i2.start) {
			return 0;
		} else {
			return i1.start < i2.start? -1: 1;
		}
	}
}

public class MergeTwoIntervalLists {
	public List<Interval> mergeList(List<Interval> l1, List<Interval> l2) {
		if (l1 == null || l1.size()  == 0) {
			return l2;
		} else if (l2 == null || l2.size() == 0) {
			return l1;
		} 
		
		Collections.sort(l1, new myComparator());
		Collections.sort(l2, new myComparator());
		
		List<Interval> result = new ArrayList<>();
		int index1 = 0;
		int index2 = 0;
		// Get the first interval
		Interval prev = null;
		if (l1.get(0).start < l2.get(0).start) {
			prev = l1.get(0);
			index1 ++;
		} else {
			prev = l2.get(0);
			index2 ++;
		}
		// Move two pointers to merge lists
		while (index1 < l1.size() || index2 < l2.size()) {
			if (index2 == l2.size() || (index1 < l1.size() && l1.get(index1).start < l2.get(index2).start)) {
				// merge prev with index1
				if (prev.end < l1.get(index1).start) {
					result.add(prev);
					prev = l1.get(index1);
				} else {
					prev.end = Math.max(prev.end, l1.get(index1).end);
				}
				index1 ++;
			} else {
				// merge prev with index2
				if (prev.end < l2.get(index2).start) {
					result.add(prev);
					prev = l2.get(index2);
				} else {
					prev.end = Math.max(prev.end, l2.get(index2).end);
				}
				index2 ++;
			}
		}		
		result.add(prev);
		return result;
	}
	
	public static void main(String[] args) {
		MergeTwoIntervalLists myObj = new MergeTwoIntervalLists();
		
		List<Interval> l1 = new ArrayList<>();
		l1.add(new Interval(1, 5));
		l1.add(new Interval(10, 14));
		l1.add(new Interval(16, 18));
		l1.add(new Interval(20, 24));
		l1.add(new Interval(30, 38));
		List<Interval> l2 = new ArrayList<>();
		l2.add(new Interval(2, 6));
		l2.add(new Interval(8, 10));
		l2.add(new Interval(11, 20));
		
		List<Interval> result = myObj.mergeList(l1, l2);
		for (Interval i1: result) {
			System.out.println("["+i1.start + ", " + i1.end+"]");
		}
	}
	
}

/*
For list of sizes m and n where n > m
Time Complexity:

O( n log n + m ) if sorting of each list is required.

If the input lists are already sorted, then the algorithm runs in O( m + n ) time

Space Complexity:
No additional memory than the result. For the result O(m + n) is used in the worst case
*/