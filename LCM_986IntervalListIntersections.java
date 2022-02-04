import java.util.*;

class Solution{
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0; 
        while(i < A.length && j < B.length){
            int maxStart = Math.max(A[i][0], B[j][0]);
            int minEnd = Math.min(A[i][1], B[j][1]);
                if(maxStart <= minEnd){
                    list.add(new int[]{maxStart, minEnd});
                }
                if(A[i][1] < B[j][1]){
                    i++;
                }
                else{
                    j++;
                }
        }
        int[][] result = new int[list.size()][2];
        i = 0;
        for(int[] arr : list){
            result[i] = arr;
            i++;
        }
        return result;
    }
}

/*
Two pointer technique 

Exmpl

A: [[0,2],[5,10],[13,23],[24,25]]
B: [[1,5],[8,12],[15,24],[25,26]]

A[0][0] = 0
B[0][0] = 1
maxStart = 1

A[0][1] =2
B[0][1] = 5
minEnd = 2

1 < 2, add to list...



Time: O(n)
Space: O(n)
 */