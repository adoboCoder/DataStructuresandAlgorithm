import java.util.*;

class LCM_636ExclusiveTimeOffFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) {
                result[stack.peek()] = result[stack.peek()] + Integer.parseInt(parts[2]) - prevTime;
            }
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) {
                stack.push(Integer.parseInt(parts[0]));
            } else {
                result[stack.pop()]++;
                prevTime++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        System.out.println(Arrays.toString(LCM_636ExclusiveTimeOffFunctions.exclusiveTime(n, logs)));
    }
}