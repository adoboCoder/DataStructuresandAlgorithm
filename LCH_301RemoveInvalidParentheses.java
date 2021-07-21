class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        char[] check = new char[] { '(', ')' };
        dfs(s, result, check, 0, 0);
        return result;
    }

    public static void dfs(String s, List<String> result, char[] check, int last_i, int last_j) {
        int count = 0;
        int i = last_i;
        while (i < s.length() && count >= 0) {

            if (s.charAt(i) == check[0])
                count++;
            if (s.charAt(i) == check[1])
                count--;
            i++;
        }

        if (count >= 0) {
            // no extra ')' is detected. We now have to detect extra '(' by reversing the
            // string.
            String reversed = new StringBuffer(s).reverse().toString();
            if (check[0] == '(')
                dfs(reversed, result, new char[] { ')', '(' }, 0, 0);
            else
                result.add(reversed);

        }

        else { // extra ')' is detected and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j - 1) != check[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1, s.length()), result, check, i, j);
                }
            }
        }
    }
}