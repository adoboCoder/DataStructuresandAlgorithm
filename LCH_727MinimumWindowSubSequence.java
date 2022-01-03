class LCH_727MinimumWindowSubSequence {
    public static String minWindow(String S, String T) {
        int start = -1;
        int len = Integer.MAX_VALUE;
        int m = S.length();
        int n = T.length();
        for (int i = 0; i < m; i++) {
            if (S.charAt(i) == T.charAt(n - 1)) {
                int k = i;
                int j = n - 1;
                for (; k >= 0; k--) {
                    if (S.charAt(k) == T.charAt(j)) j--;
                    if (j == -1) break;
                }
                if (j == -1 && i - k + 1 < len) { 
                    len = i - k + 1;
                    start = k;
                }
            }
        }
        if (start == -1) return "";
        return S.substring(start, start + len);
    }
    public static void main(String[] args) {
        String s = "abcdebdde";
        String t = "bde";
        System.out.println(LCH_727MinimumWindowSubSequence.minWindow(s, t));

        s = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl";
        t = "u";
        System.out.println(LCH_727MinimumWindowSubSequence.minWindow(s, t));

    }

}