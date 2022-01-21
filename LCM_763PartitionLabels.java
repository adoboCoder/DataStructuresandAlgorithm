import java.util.*;

class LCM_763PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26]; // record the last index of the each char

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, map[s.charAt(i) - 'a']);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ababcbacadefegdehijhklij";
        String s2 = "eccbbbbdec";
        System.out.println(LCM_763PartitionLabels.partitionLabels(s1));
        System.out.println(LCM_763PartitionLabels.partitionLabels(s2));
    }
}