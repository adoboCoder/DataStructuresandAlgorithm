import java.util.*;

public class Solution {
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> qStart = new HashSet<>();
        Set<String> qEnd = new HashSet<>();
        Set<String> vis = new HashSet<>();
        
        qStart.add(beginWord);
        if (dict.contains(endWord)){
            qEnd.add(endWord); // all transformed words must be in dict (including endWord)
        } 
        for (int len = 2; !qStart.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qStart) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)){
                          continue; // beginWord and endWord not the same, so bypass itself   
                        }
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qEnd.contains(nb)){
                          return len; // meet from two ends  
                        } 
                        if (dict.contains(nb) && vis.add(nb)){
                          nq.add(nb); // not meet yet, vis is safe to use  
                        } 
                    }
                }
            }
            qStart = (nq.size() < qEnd.size()) ? nq : qEnd; // switch to small one to traverse from other end
            qEnd = (qStart == nq) ? qEnd : nq;
        }
        return 0;
    }
}