class Solution{
    public int partitionDisjoint(int[] a){
        int localMax = a[0];
        int partitionIndex = 0;
        int max = localMax;

        for(int i = 1; i < a.length; i++){
            if(localMax > a[i]){
                localMax = max;
                partitionIndex = i;
            }
            else{
                max = Math.max(max, a[i]);
            }
        }
        return partitionIndex + 1;
    }
}