import java.util.*;

class LCE_167TwoSumIIInputArrayIsSorted {
    public static int[] twoSum (int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a;
        int num_b;
        
        while(a_pointer < b_pointer) {
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];
            
            if(num_a + num_b == target) break;
            
            if(num_a + num_b < target) {
                a_pointer++;
                continue;
            }
            
            b_pointer--;
            
        }
        
        return new int[]{a_pointer + 1, b_pointer + 1};
    }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }
}