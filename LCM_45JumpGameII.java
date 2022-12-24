class LCM_45JumpGameII {
    public static int jump(int[] nums) {
        int result = 0;
        int currentEnd = 0;
        int currenetFarthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            currenetFarthest = Math.max(currenetFarthest, i + nums[i]);
            if(i == currentEnd) {
                result++;
                currentEnd = currenetFarthest;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(LCM_45JumpGameII.jump(nums));
    }
}