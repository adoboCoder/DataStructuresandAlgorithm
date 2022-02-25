import java.util.*;

class LCM_825FriendsOfAppropriateAges {
    public static int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }
        int result = 0;
        for(int a : map.keySet()) {
            for(int b : map.keySet()) {
                if(request(a, b)) {
                    result = result + map.get(a) * (map.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return result;
    }
    private static boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }

    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[] {16,16}));
        System.out.println(numFriendRequests(new int[] {16,17,18}));
        System.out.println(numFriendRequests(new int[] {20,30,100,110,120}));
    }
}