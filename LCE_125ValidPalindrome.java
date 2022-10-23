class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(start < end && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))){
                return false;
            }       
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String t = "A n";

        System.out.println(ValidPalindrome.isPalindrome(s));
        System.out.println(ValidPalindrome.isPalindrome(t));
    }
}