package Blind75.Arrays;

import java.util.*;

public class ValidAnagram {
    public static boolean iSAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for(int a : alphabet) {
            if(a != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(ValidAnagram.iSAnagram("anagram", "nagaram"));
        System.out.println(ValidAnagram.iSAnagram("rat", "car"));
        System.out.println(ValidAnagram.iSAnagram("racecar", "racerac"));
    }
}
