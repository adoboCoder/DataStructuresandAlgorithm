package Blind75.DynamicProgramming;

public class HouseRobber {
    public static int rob(int[] nums) {
<<<<<<< HEAD
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
=======
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
>>>>>>> 0ec6c9f9c013b68e017256ae6ccb986b15d6064b

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

<<<<<<< HEAD
        for(int i = 2; i < dp.length; i++) {
=======
        for (int i = 2; i < dp.length; i++) {
>>>>>>> 0ec6c9f9c013b68e017256ae6ccb986b15d6064b
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
<<<<<<< HEAD
    public static void main(String[] args) {
        System.out.println(HouseRobber.rob(new int[] {1, 2, 3, 1}));
=======

    public static void main(String[] args) {
        System.out.println(HouseRobber.rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(HouseRobber.rob(new int[] { 2, 7, 9, 3, 1 }));
>>>>>>> 0ec6c9f9c013b68e017256ae6ccb986b15d6064b
    }
}
