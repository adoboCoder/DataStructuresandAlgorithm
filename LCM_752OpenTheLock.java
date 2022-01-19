import java.util.*;

class LCM_752OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        int depth = -1;

        q.addAll(Arrays.asList("0000"));

        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(target)) {
                    return depth;
                }
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                q.addAll(getSuccessor(node));
            }
        }
        return -1;
    }

    private static List<String> getSuccessor(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            result.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(LCM_752OpenTheLock.openLock(deadends, target));
    }
}