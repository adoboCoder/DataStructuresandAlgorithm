import java.util.*;
class Solution {

    Random random;
    int[] weightSums;
    
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; i++)
            w[i] += w[i-1];
        this.weightSums = w;
    }
    
    public int pickIndex() {
        int len = weightSums.length;
        int index = random.nextInt(weightSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(weightSums[mid] == index)
                return mid;
            else if(weightSums[mid] < index)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}