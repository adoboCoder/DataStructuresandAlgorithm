import java.util.*;

class LCM_792NumberOfMatchingSubsequences {
    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        
        for(char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        
        for(String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        
        int count = 0;
        
        for(char c : s.toCharArray()) {
            Deque<String> q = map.get(c);
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                String word = q.removeFirst();
                if(word.length() == 1) {
                    count++;
                }
                else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(LCM_792NumberOfMatchingSubsequences.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
        System.out.println(LCM_792NumberOfMatchingSubsequences.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }
}