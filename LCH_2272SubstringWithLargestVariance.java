import java.util.*;

class LCH_2272SubstringWithLargestVariance {
    public static int largestVariance(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[(int)(s.charAt(i) - 'a')]++;
        }

        int maxVariance = 0;

        for(int a = 0; a < 26; a++) {
            for(int b = 0; b < 26; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];

                if(a == b || remainingA == 0 || remainingB == 0) continue;

                int currentFreqA = 0;
                int currentFreqB = 0;

                for(int i = 0; i < s.length(); i++) {
                    int c = (int)(s.charAt(i) - 'a');

                    if(c == b) currentFreqB++;
                    if(c == a){
                        currentFreqA++;
                        remainingA--;
                    }
                    if(currentFreqA > 0)
                        maxVariance = Math.max(maxVariance, currentFreqB - currentFreqA);
                    
                    if(currentFreqB < currentFreqA && remainingA >= 1) {
                        currentFreqB = 0;
                        currentFreqA = 0;
                    }
                }
            }
        }
        return maxVariance;
    }

    public static void main(String[] args) {
        System.out.println(LCH_2272SubstringWithLargestVariance.largestVariance(3)));    
    }
}