class LCE_1047RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            int size = sb.length();
            if(size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = "azxxzy";

        System.out.println(LCE_1047RemoveAllAdjacentDuplicatesInString.removeDuplicates(s));
        System.out.println(LCE_1047RemoveAllAdjacentDuplicatesInString.removeDuplicates(s1));
    }
}