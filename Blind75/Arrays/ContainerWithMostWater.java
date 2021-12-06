package Blind75.Arrays;

public class ContainerWithMostWater {
    public static int findMostWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(ContainerWithMostWater.findMostWater(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
