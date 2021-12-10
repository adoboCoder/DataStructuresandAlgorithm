
package Blind75.Graph;
import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);

        int result = 0;
        for(int n : set) {
            if(!set.contains(n - 1)){
                int m = n + 1;
                while(set.contains(m)){
                    m++;
                }
                result = Math.max(result, m - n);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1 , 3, 2};
        System.out.println(LongestConsecutiveSequence.longestConsecutiveSequence(nums));
    }
}
