class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
          sum += cardPoints[i];  
        } 
        
        max = sum;
        for(int i = 1; i <= k; i++){
            int right =  cardPoints[cardPoints.length -i];
            int left = cardPoints[k - i];
            sum = sum + right - left;
            max = Math.max(max, sum);
        }
        return max;
    }
}

//Time O(n)