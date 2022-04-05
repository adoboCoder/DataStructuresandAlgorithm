class LCM_616AddBoldTagInString {
    public static String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for(String w : words) {
            int start = 0;
            while(start >= 0) {
                start = s.indexOf(w, start);
                if(start < 0) break;
                int end = start + w.length();
                for(int i = start; i < end; i++) {
                    bold[i] = true;
                }
                start++; // Just start from next index, instead of iterating through entire string
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) { 
            if(bold[i] && (i - 1 < 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i)); // Just go character by character rather than cutting up the string
            if(bold[i] && (i + 1 == s.length() || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
    public static void main(String[]args) {
        String s = "abcxyz123";
        String[] words = new String[] {"abc","123"};
        System.out.println(LCM_616AddBoldTagInString.addBoldTag(s, words));

        String s1 = "aaabbcc";
        String[] words1 = new String[] {"aaa","aab","bc"};
        System.out.println(LCM_616AddBoldTagInString.addBoldTag(s1, words1));
    }
}

// TC : O(NML) N is the length of s, M is the length of words, L is the average length of each word in dict
// SC : O(n)