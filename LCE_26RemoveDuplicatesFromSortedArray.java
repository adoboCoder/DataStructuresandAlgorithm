class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
/*
Time: O(n)
Space: O(1)

This uses the two pointer technique to iterate through the array. 

[0,0,1,2,2,3,4,4,5]
 |
slow
  |
  fast

The fast pointer will keep moving until we see another number that's different than the slow pointer. 
Once found, we increment the slow pointer to preserve the slow pointer's occurance and replace it with the fast pointer.  
Keep iterating through the entire array.

We're returning i + 1 because arrays are zero based, to return the length the array we need  to add one.
*/
