import java.util.*;

class LCM_1405LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }

    public static String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b)
            return generate(b, a, c, bb, aa, cc);
        if (b < c)
            return generate(a, c, b, aa, cc, bb);
        if (b == 0)
            return String.join("", Collections.nCopies(Math.min(2, a), aa));

        int aUsed = Math.min(2, a);
        int bUsed = a - aUsed >= b ? 1 : 0;

        return String.join("", Collections.nCopies(Math.max(aUsed, bUsed), aa))
                + String.join("", Collections.nCopies(bUsed, bb))
                + generate(a - aUsed, b - bUsed, c, aa, bb, cc);
    }

    public static void main(String[] args) {
        System.out.println(LCM_1405LongestHappyString.longestDiverseString(1, 1, 7));
    }
}