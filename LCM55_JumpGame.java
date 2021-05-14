class LCM55_JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            if(i > max){
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 4, 5};
        for(int n : test){
            System.out.print("[" + n + "]");
            System.out.println();
        }
        System.out.println("Can jummp: " + LCM55_JumpGame.canJump(test));
        
    }
}