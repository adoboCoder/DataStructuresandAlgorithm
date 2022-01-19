import java.util.*;
class LCM_442FindAllDuplicatesInAnArray {
    public static List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(LCM_442FindAllDuplicatesInAnArray.findDuplicates(nums));


        int[] nums2 = {1, 1, 3, 9, 3, 7, 8, 2, 6, 7};
        System.out.println(LCM_442FindAllDuplicatesInAnArray.findDuplicates(nums2));
    }

}