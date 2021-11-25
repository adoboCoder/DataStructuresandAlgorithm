import java.util.*;

class LCM_900RLEIterator {
    public int[] encoding; 
    public int index; 

    public LCM_900RLEIterator(int[] encoding) {
        this.encoding = encoding;
        index = 0;
    }

    public int next(int n) {
        while(index < encoding.length && n > encoding[index]) {
            n = n - encoding[index];
            index = index + 2;
        }

        if(index >= encoding.length) {
            return -1;
        }

        encoding[index] = encoding[index] - n;
        return encoding[index + 1];
    }
}