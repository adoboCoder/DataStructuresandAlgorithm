import java.util.*;

class LCE_1331RankTransformOfAnArray{
    public static int[] arrayRankTransform(int[] nums) {
        int[] A = Arrays.copyOf(nums, nums.length);
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : A) {
            map.putIfAbsent(x, map.size() + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            A[i] = map.get(nums[i]);
        }
        return A;
    }

    public static void main(String[] args){
        int[] nums = {40,10,20,30};
        int[] result = arrayRankTransform(nums);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
/*
Time O(NlogN)
Space O(N)
*/