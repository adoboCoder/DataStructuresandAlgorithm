import java.util.*;

class LCM1386_CinemaSeatingAllocation {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int key = reservedSeats[i][0];
            int value = reservedSeats[i][1];
            map.putIfAbsent(key, new HashSet<>());
            map.get(key).add(value);
        }

        int result = 2 * (n - map.size());

        for (int k : map.keySet()) {
            Set<Integer> set = map.get(k);
            boolean l = true;
            boolean r = true;
            boolean m = true;
            if (set.contains(4) || set.contains(5)) {
                l = false;
                m = false;
            }
            if (set.contains(6) || set.contains(7)) {
                r = false;
                m = false;
            }
            if (l && set.contains(2) || set.contains(3)) {
                l = false;
            }
            if (r && set.contains(8) || set.contains(9)) {
                r = false;
            }
            if (l && r)
                result += 2;
            else if (l || r || m)
                result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] seats = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
        int n = 2;
        System.out.println(LCM1386_CinemaSeatingAllocation.maxNumberOfFamilies(n, seats));
        int[][] seats1 = { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
        n = 4;
        System.out.println(LCM1386_CinemaSeatingAllocation.maxNumberOfFamilies(n, seats1));
    }
}