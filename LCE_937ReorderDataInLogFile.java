import java.util.*;

class LCE_937ReorderDataInLogFile {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            String l1 = s1.substring(idx1 + 1);
            String l2 = s2.substring(idx2 + 1);

            if (l1.charAt(0) <= '9') {
                if (l2.charAt(0) <= '9')
                    return 0;
                else
                    return 1;
            } else {
                if (l2.charAt(0) <= '9')
                    return -1;
                else {
                    int cmpContent = l1.compareTo(l2);
                    if (cmpContent != 0)
                        return cmpContent;
                    return s1.substring(0, idx1).compareTo(s2.substring(0, idx2));
                }
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}