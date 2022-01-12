import java.util.*;

class LCM_1010PairsOfSongsWithTotalDurationDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int time : times){
            int remainder = time % 60;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        int res = 0;
        for(int remainder : map.keySet()){
            if(remainder > 30) continue;
            if(remainder == 0 || remainder == 30){
                int size = map.get(remainder);
                res += size * (size - 1) / 2;
            }else{
                res += map.get(remainder) * map.getOrDefault(60 - remainder, 0);
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] times = {30,20,150,100,40};
        System.out.println(LCM_1010PairsOfSongsWithTotalDurationDivisibleBy60.numPairsDivisibleBy60(times));
    }
}