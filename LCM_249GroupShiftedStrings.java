import java.util.*;

class LCM_249GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            //Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] str = {"abc","bcd","acef","xyz","az","ba","a","z"};
        System.out.println(groupStrings(str));
    }
}

/*
TC: O(NK) N Length of Strings array, K length of longest string
SC: O(NK)
*/