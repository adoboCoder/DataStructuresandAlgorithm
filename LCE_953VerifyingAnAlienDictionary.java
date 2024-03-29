class LCE_953VerifyingAnAlienDictionary {
    public static int[] mapping = new int[26];
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++){
            if (compare(words[i], words[i+1])){
                return false;
            }
        }
    return true;
    }
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

    private static boolean compare(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n && i < m; ++i){
            if (s1.charAt(i) != s2.charAt(i)) {
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
            }
        }
        return n > m;
    }

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
}