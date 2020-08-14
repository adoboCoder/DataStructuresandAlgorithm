class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int p : prices){
            min = Math.min(min, p);
            max = Math.max(p - min, max);
        }
        return max;
    }
}