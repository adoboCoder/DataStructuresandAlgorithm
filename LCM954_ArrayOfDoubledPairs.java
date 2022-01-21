import java.util.*;

class LCM954_ArrayOfDoubledPairs {
    public static boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int x : arr) {
            if (map.get(x) == 0)
                continue;
            if (x < 0 && x % 2 != 0) // For example: arr=[-5, -2, 1, 2], x = -5, there is no x/2 pair to match
                return false;
            int y = x > 0 ? x * 2 : x / 2;
            if (map.getOrDefault(y, 0) == 0)// Don't have the corresponding `y` to match with `x` -> Return IMPOSSIBLE!
                return false;

            map.put(x, map.get(x) - 1);
            map.put(y, map.get(y) - 1);

        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 3, 6 };
        System.out.println(LCM954_ArrayOfDoubledPairs.canReorderDoubled(arr));

        int[] arr1 = { 4, -2, 2, -4 };
        System.out.println(LCM954_ArrayOfDoubledPairs.canReorderDoubled(arr1));
    }
}