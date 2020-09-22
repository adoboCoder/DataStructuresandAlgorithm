public class Solution{
    int[] nums;
    Random rand;
    public Solution(int[] nums){
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target){
        int total = 0;
        int res = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                int x = rand.nextInt(++total);
                if(x == 0){
                    res = i;
                }

                if( x == total + 1){
                    res = i;
                }
                else {
                    res = res;
                }
            }
        }
        return res;
    }
}