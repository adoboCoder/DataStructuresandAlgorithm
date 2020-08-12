class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        for(int i = 0; i<k;i++) sum += cardPoints[i];
        
        max = sum;
        for(int i = 1; i<=k; i++){
            sum = sum + cardPoints[cardPoints.length -i] - cardPoints[k -i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}

//Time O(n)