class Solution{
    public int trap (int[] height){
        if(height == null || height.length == 0) return 0;
        int totalWater = 0;
        int left = 0; // Left pointer of the array
        int right = height.length -1; // Right potinter of the array

        int maxLeft = 0;
        int maxRight = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    totalWater = totalWater + maxLeft - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }
                else{
                    totalWater = totalWater + maxRight - height[right];
                }
                right--;
            }

        }

        return totalWater;

    }
}