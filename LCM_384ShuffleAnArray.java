import java.util.*;

class LCM_384ShuffleAnArray {
    private int[] nums;
    private Random random;

    public LCM_384ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] random = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            random[i] = random[r];
            random[r] = nums[i];
        }
        return random;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(nums));
        LCM_384ShuffleAnArray solution = new LCM_384ShuffleAnArray(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }
}