class LCM_1209RemoveAllAdjacentDuplicatesInStringII {
    public static String removeDuplicates(String s, int k) {
        int i = 0;
        int n = s.length();
        int count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        System.out.println(LCM_1209RemoveAllAdjacentDuplicatesInStringII.removeDuplicates(s, 3));
    }
}