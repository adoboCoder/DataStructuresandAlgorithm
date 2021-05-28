import java.util.*;

class LCE_696CountBinarySubStrings {
    public static int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int currentLength = 1;
        int previousLength = 0;
        int count = 0;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            }
            else {
                previousLength = currentLength;
                currentLength = 1;
            }

            if(previousLength >= currentLength) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(LCE_696CountBinarySubStrings.countBinarySubstrings("00110011"));
    }
}