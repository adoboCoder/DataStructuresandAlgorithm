class LCE_160RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1]){
            nums[i] = n;
            i++;
        }
            
    return i;
    }

    public static void main(String[] args) {
        int[] input =  {1, 2, 2, 4, 5, 6};
        System.out.println(LCE_160RemoveDuplicatesFromSortedArray.removeDuplicates(input));
        
        
    }
}