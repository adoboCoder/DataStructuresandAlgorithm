class Solution {
    public int getMaxLen(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for(int i = 0; i < n;) {
            int start = i;
            
            while(start < n && nums[start] == 0) start++;
            
            int end = start;
            int negative = 0;
            int firstNe = -1, lastNe = -1;
            
            while(end < n && nums[end] != 0) {
                if(nums[end] < 0) {
                    if(firstNe == -1) firstNe = end;
                    lastNe = end;
                    negative++;
                }
                end++;
            }
            
            if(negative % 2 == 0) answer = Math.max(answer, end - start);
            else {
                answer = Math.max(answer, end - firstNe - 1);
                answer = Math.max(answer, lastNe - start);
            }
            
            i = end + 1;    
        }
        return answer;
    }
}