class LCH_10RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];

        return dfs(cache, s, p, 0, 0);
    }

    private static boolean dfs(boolean[][] cache, String s, String p, int i, int j) {
        if (cache[i][j] != false) return cache[i][j];

        if (i >= s.length() && j >= p.length()) return true;

        if (j >= p.length()) return false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            cache[i][j] =
                dfs(cache, s, p, i, j + 2) || //dont use *
                (match && dfs(cache, s, p, i + 1, j)); //use *
        } else {
            cache[i][j] = match && dfs(cache, s, p, i + 1, j + 1);
        }

        return cache[i][j];
    } //top down Memoization
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(LCH_10RegularExpressionMatching.isMatch(s,p));
        s = "aaaaaaaaaa";
        p = "a*";
        System.out.println(LCH_10RegularExpressionMatching.isMatch(s,p));
        s = "abff";
        p = ".f*";
        System.out.println(LCH_10RegularExpressionMatching.isMatch(s,p));
    }
}

// first character of pattern (p) cannot be a star (*) -> false
