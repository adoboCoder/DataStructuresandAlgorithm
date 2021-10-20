import java.util.*;

class LCH_1153StringTransformIntoAnotherString {
    public static boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "ccdee";

        System.out.println(LCH_1153StringTransformIntoAnotherString.canConvert(s1, s2));

    }
}