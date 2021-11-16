import java.util.*;

class LCE680_ValidPalindromeII{
    public static boolean validPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while( left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right -1);
            }
        }
        return true;
    }
    
    private static boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "aba";
        System.out.println(LCE680_ValidPalindromeII.validPalindrome(input));

        input = "abca";
        System.out.println(LCE680_ValidPalindromeII.validPalindrome(input));

        input = "abc";
        System.out.println(LCE680_ValidPalindromeII.validPalindrome(input));
    }
}   