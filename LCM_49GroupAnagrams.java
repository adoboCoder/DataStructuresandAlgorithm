import java.util.*;

class LCM_49GroupAnagrams {
    public static List<List<String>> groupAnagrams (String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0 || strs == null) return result;

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] hash = new char[26];
            for(char c : s.toCharArray()) {
                hash[c - 'a']++;

            }
            String str = new String(hash);
            if(map.get(str) == null) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        result.addAll(map.values());
        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(List<String> list : result) {
            for(String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}