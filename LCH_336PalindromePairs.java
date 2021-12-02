import java.util.*;

class LCH_336PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        if (map.containsKey("")) {
            int blankIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i])) {
                    if (i == blankIndex)
                        continue;
                    result.add(Arrays.asList(blankIndex, i));
                    result.add(Arrays.asList(i, blankIndex));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String curr = reverse(words[i]);
            if (map.containsKey(curr)) {
                int found = map.get(curr);
                if (found == i)
                    continue;
                result.add(Arrays.asList(i, found));
            }
        }

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                if (isPalindrome(cur.substring(0, cut))) {
                    String cut_r = reverse(cur.substring(cut));
                    if (map.containsKey(cut_r)) {
                        int found = map.get(cut_r);
                        if (found == i)
                            continue;
                        result.add(Arrays.asList(found, i));
                    }
                }
                if (isPalindrome(cur.substring(cut))) {
                    String cut_r = reverse(cur.substring(0, cut));
                    if (map.containsKey(cut_r)) {
                        int found = map.get(cut_r);
                        if (found == i)
                            continue;
                        result.add(Arrays.asList(i, found));
                    }
                }
            }
        }
        return result;

    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
        System.out.println(LCH_336PalindromePairs.palindromePairs(words));
    }
}