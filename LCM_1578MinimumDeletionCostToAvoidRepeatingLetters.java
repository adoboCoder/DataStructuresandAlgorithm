class Solution{
    public int minCost(String s, int[] cost){
       char[] arr = s.toCharArray();
       int result = 0;
       int sum = arr[0];
       int max = arr[0];

       for(int i = 1; i < arr.length; i++){
           if(arr[i] != arr[i-1]){
               result = result + sum - max;
               sum = 0;
               max = 0;
           }
           max = Math.max(max, cost[i]);
           sum = sum + cost[i];
       }
       return result + sum - max;
    }
}