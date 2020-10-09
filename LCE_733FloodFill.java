class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor){
            return image;
        }
            
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}


/*
Time: O(m*n) because it's possible that we might have to process every pixel (m*n or the whole image)
Space: O(n)

This is a classic DFS problem.  The fill method is a helper method that will perform most of the work.
In the main method, we check the starting point image[startingRow][startingColumn] to see if it's already the newColor, 
if it is then we just return the image (base case). If not, then we pass it on the helper method which utilizes DFS with recursion.


*/