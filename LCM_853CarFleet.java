import java.util.*;

class LCM_853CarFleet{
    public static int findCarFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;

        for(int i = 0; i < n; i++) {
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int dist = entry.getKey();
            int sp = entry.getValue();
            double timeToTarget = 1.0 * dist / sp;
            if(timeToTarget > r) {
                count++;
                r = timeToTarget;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        System.out.println(LCM_853CarFleet.findCarFleet(target, position, speed));
    }   
}