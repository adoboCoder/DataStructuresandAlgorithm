class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        for(int i = 0; i < k; i++){
          sum += cardPoints[i];  
        } 
        
        max = sum;
        for(int i = 1; i <= k; i++){
            int x =  cardPoints[cardPoints.length -i];
            int y = cardPoints[k - i];
            sum = sum + x - y;
            max = Math.max(max, sum);
        }
        return max;
    }
}

//Time O(n)