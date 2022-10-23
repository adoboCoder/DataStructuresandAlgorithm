class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right -left));
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}

/*
This solution utilzes the two pointer technique applied to the incomoing array input.  
One pointer is pointed at the start of the array: left
The other pointer is pointed at the end of the array: right

We're iteratign  through the  array to find the maximum area where the elements in the array are the height of square/rectangle (left * right)

Time:O(n)
Space: O(1)
*/
