import java.util.*;

class LCM_1554StringsDifferByOneCharacter {
    public static boolean differByOne(String[] dict) {
        for (int i = 0; i < dict[0].length(); i++) {
            Set<String> set = new HashSet<>();
            for (String word : dict) {
                if (!set.add(word.substring(0, i) + word.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] dict = {"abcd","acbd","aacd"};
        System.out.println(LCM_1554StringsDifferByOneCharacter.differByOne(dict));
    }
}