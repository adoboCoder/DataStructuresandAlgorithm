import java.util.*;
class LCE_266PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Set<Character> hs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            if(!hs.contains(s.charAt(i))){
                hs.add(s.charAt(i));
            }
            else{
                hs.remove(s.charAt(i));
            }
        }
        return hs.size() == 1 || hs.size() == 0;
    }
    public static void main (String[] args) {
        String s = "code";
        String s1 = "carerac";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindrome(s1));
    }
}
/*
TC: O(n)
SC: O(1)
*/