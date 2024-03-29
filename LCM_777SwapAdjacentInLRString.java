import java.util.*;

class LCM_777SwapAdjacentInLRString {
    public static boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();

        int i = 0;
        int j = 0;

        while(i < start.length() || j < end.length()) {
            //Move until see a character that is not "X"
            while(i < s.length && s[i] == 'X') i++;
            while(j < e.length && e[j] == 'X') j++;

            if(i >= s.length || j >= e.length) break;

            if(s[i] != e[j]) return false;

            if(s[i] == 'R' && i > j) return false;

            if(e[j] == 'L' && i < j) return false;
            
            i++;
            j++;
        }
        return i == j;
    }
    public static void main(String[] args) {
        System.out.println(LCM_777SwapAdjacentInLRString.canTransform("RXXLRXRXL","XRLXXRRLX"));
    }
}