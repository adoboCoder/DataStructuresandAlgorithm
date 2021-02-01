class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128]; //ASCII Characters 
        
        //Initialize map for lookup
        for(char c : t.toCharArray()) {
            map[c]++;
        }
        
        //Set pointers
        int start = 0;
        int end = 0;
        //Set Counter
        int counter = t.length();
        
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0){
                counter--;     
            }
                map[c1]--;
                end++;
                while (counter == 0) {
                    if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                    }
                    final char c2 = s.charAt(start);
                    map[c2]++;
                    if (map[c2] > 0) {
                        counter++;  
                    } 
                    start++;
                }
    }

    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }
}

//  Time:  O(s+t)
//  Space:  O(n)