import java.util.*;

class LCM_560SubarraySumEqualsK{
    public static int subarraySum(int[] nums, int k){
        if(nums.length == 0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0,1);
        for(int i : nums){
            sum += i;
            if(map.containsKey(sum - k)){
                result = result + map.get(sum - k);
            }    
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(test));
        
        System.out.println(LCM_560SubarraySumEqualsK.subarraySum(test, 3));
    }
}
