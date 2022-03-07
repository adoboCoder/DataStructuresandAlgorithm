class LCE_1614MaximumNestingDepthOfTheParentheses {
    public static int maxDepth(String s) {
        int result = 0;
        int current = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                current++;
                result = Math.max(result, current);
            }
            if(s.charAt(i) == ')') {
                current--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        String s2 = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s1));
        System.out.println(maxDepth(s2));
    }
}