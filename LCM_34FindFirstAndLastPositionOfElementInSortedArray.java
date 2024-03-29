import java.util.*;

class LCM_34FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target) {
        int index = -1; // can't find target
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }

    private static int findLast(int[] nums, int target) {
        int index = -1; // can't find target
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
        System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[] { 10, 10, 10, 10, 10, 10 }, 10)));
    }
}

/* Time: O(logN)
 * Space: O(1)
 */