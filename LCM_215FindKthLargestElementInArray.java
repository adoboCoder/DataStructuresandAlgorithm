import java.util.*;

class LCM_215FindKthLargestElementInArray{
    public static int findKthLargest_minHeap(int [] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i : nums){
            minHeap.add(i);

            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    public static int findKthLargest_quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int low, int high, int k /* index we're looking for */) {
        int i = low;
        int j = high;
        int pivot = nums[high];

        //partition numbers into either side of pivot
        while(i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }

        swap(nums, i, high);

        //how many elements were greater than pivot
        if(i == k)
            return nums[i];
        else if(i > k)
            return quickSelect(nums, low, i-1, k);
        else
            return quickSelect(nums, i+1, high, k);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int[] nums2 = {3,2,1,5,6,4};

        System.out.println(findKthLargest_minHeap(nums, 2));
        System.out.println(findKthLargest_quickSelect(nums, 2));

        System.out.println();
        System.out.println(findKthLargest_minHeap(nums2, 4));
        System.out.println(findKthLargest_quickSelect(nums2, 4));
    }
}

/*
MinHeap Solution : Time Complexity: O(nlogk)
space Complexity: O(k)

quickSelect Solution : Time Complexity: O(n)
space Complexity: O(1)
 */