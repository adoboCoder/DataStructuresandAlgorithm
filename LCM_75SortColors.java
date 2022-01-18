import java.util.*;

class LCM_75SortColors {
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        for(int i = 0; i <= high;) {
            if(nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            }
            else if( nums[1] == 1) {
                i++;
            }
            else {
                swap(nums, i, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}