import java.util.*;

class LCM_833FindAndReplaceInString {
    public static String findRepalceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        int i = 0;
        while (i < s.length()) {
            if (sourceMap.containsKey(i) && s.startsWith(sourceMap.get(i), i)) {
                sb.append(targetMap.get(i));
                i = i + sourceMap.get(i).length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = { 0, 2 };
        String[] sources = { "a", "cd" };
        String[] targets = { "eee", "ffff" };
        System.out.println(LCM_833FindAndReplaceInString.findRepalceString(s, indices, sources, targets));
    }

}