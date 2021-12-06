package Blind75.Arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int currentMax = 0; 
        int maxSoFar = 0; 
        for(int i = 1; i < prices.length; i++) {
            currentMax = Math.max(0, currentMax + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(currentMax, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] {7,6,4,3,1}));
    }
}
