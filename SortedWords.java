class SortedWords {
    public static int[] mapping = new int[26];
    public static boolean isSorted(String[] words, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            mapping[alphabet[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++){
            if (compare(words[i], words[i+1])){
                return false;
            }
        }
        return true;
    }
    public static boolean compare(String s, String t) {
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n && i < m; ++i){
            if (s.charAt(i) != t.charAt(i)) {
                return mapping[s.charAt(i) - 'a'] > mapping[t.charAt(i) - 'a'];
            }
        }
        return n > m;
    }
    public static void main(String[] args) {
        String[] words = {"cat","bat", "tab"};
        char[] alphabet = {'c', 'b', 'a', 't'};

        System.out.println(isSorted(words, alphabet));
    }
}