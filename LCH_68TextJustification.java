import java.util.*;

class LCH_68TextJustification {
    public static List<String> fullyJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while(i < n) {
            int j  = i + 1;
            int lineLength = words[i].length();
            while(j < n && (lineLength + words[j].length() + (j - i -1) < maxWidth)) {
                lineLength += words[j].length();
                j++;
            }
            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            if(numberOfWords == 1 || j >= n) {
                result.add(leftJustify(words, diff, i, j));
            }
            else {
                result.add(middleJustify(words, diff, i, j));
            }
            i = j;
            
        }
        return result;
    }
    private static String leftJustify(String[] words, int diff, int i, int j) {
        int spacesOnRight = diff - (j - i - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i +1; k < j; k++) {
            sb.append(" " + words[k]);
        }
        sb.append(" ".repeat(spacesOnRight));
        return sb.toString();
    }
    
    private static String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded; 
        int extraSpaces = diff % spacesNeeded;
        StringBuilder sb = new StringBuilder(words[i]);
        
        for(int k = i + 1; k < j; k++) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply) + words[k]);
        }
        return sb.toString();
    }
//Time: O(lines * maxWidth)
//Space: O(lines * maxWidth)
    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        System.out.println(LCH_68TextJustification.fullyJustify(words, 16));
        System.out.println();
        String[] words1 = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(LCH_68TextJustification.fullyJustify(words1, 16));
    }
}