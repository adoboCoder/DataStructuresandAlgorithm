class Solution {
     public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();

		for (int current : nums) {

			if (current > lower) {
				result.add(toString(lower, current - 1));
			}
			if (current == upper) {
				return result; // Avoid overflow
			}

			// update lower
			lower = current + 1;
		}
		
		// upper provided is bigger then last arr element
		if (lower <= upper) {
			result.add(toString(lower, upper));
		}
		return result;
	}

	private String toString(int start, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append(start);
		if (start < end) {
			sb.append("->").append(end);
		}
		return sb.toString();
	}
}

/*
Time: O(n)
Space: O(1)

Going through the nums array with the for loop.  There are two conditions in the loop.  
1. current > lower which means the current number is in the range between lower and upper.  We print the sequence.
2. current == upper means that we've gone through the whole sequence already
3. If either of the two above are true, then we need to update the lower by adding 1 to lower.
*/