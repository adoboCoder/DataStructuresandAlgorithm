package Blind75.Arrays;
import java.util.*;

public class ContainsDuplicate {
    public static boolean ContainsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ContainsDuplicate.ContainsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
        System.out.println(ContainsDuplicate.ContainsDuplicate(new int[] {1,2,3,4}));
    }
}
