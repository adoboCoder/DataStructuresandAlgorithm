import java.util.*;
class LCE_246StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        int[] map = new int[10];
        map[6] = 9;
        map[9] = 6;
        map[1] = 1;
        map[0] = 0;
        map[8] = 8;
        
        char[] ca = num.toCharArray();
        int i = 0;
        int j = ca.length - 1;
        while(i <= j) {
            int begin = ca[i] - '0';
            int end = ca[j] - '0';
            if((begin != 0 && map[begin] == 0) || map[begin] != end) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));
        System.out.println(isStrobogrammatic("88"));
        System.out.println(isStrobogrammatic("96"));
        System.out.println(isStrobogrammatic("00"));
        System.out.println(isStrobogrammatic("962"));
    }
}

//TC O(N)
// SC O(1)