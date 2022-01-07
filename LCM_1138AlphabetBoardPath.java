
class LCM_1139AlphabelBoardPath {
public static String alphabetBoardPath(String target, int rows) {
    // starting point(x,y)
    int x = 0, y = 0;
    StringBuilder sb = new StringBuilder();
    for (char c : target.toCharArray()) {
        int x1 = (c-'a') / rows;
        int y1 = (c-'a') % rows;
        while (x1 < x) {x--; sb.append('U');}
        while (y1 > y) {y++; sb.append('R');}
        while (y1 < y) {y--; sb.append('L');}
        while (x1 > x) {x++; sb.append('D');}
        sb.append('!');
    }
    return sb.toString();
}
    public static void main(String args[]) 
    { 
        String output = alphabetBoardPath("zdz", 5);
        System.out.println(output); 
    } 
} 
