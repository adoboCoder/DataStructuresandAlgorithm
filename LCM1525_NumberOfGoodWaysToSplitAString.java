import java.util.*;

class LCM1525_NumberOfGoodWaysToSplitAString {
    public static int numSplits(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;

        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            leftMap.put(c, leftMap.getOrDefault(c, 0) - 1);

            if (leftMap.get(c) == 0) {
                leftMap.remove(c);
            }

            rightMap.put(c, rightMap.getOrDefault(c, 0) + 1);
            if (leftMap.size() == rightMap.size()) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LCM1525_NumberOfGoodWaysToSplitAString.numSplits("aacaba")); // 2
        System.out.println(LCM1525_NumberOfGoodWaysToSplitAString.numSplits("abcd")); // 1
    }
}