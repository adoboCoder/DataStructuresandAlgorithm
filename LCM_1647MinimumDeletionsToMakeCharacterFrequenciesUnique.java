class Solution{
    public int minDeletions(String s){
        int[] freqCount = new int[26];

        for(char c : s.toCharArray()){
            freqCount[c - 'a']++;
        }
        Set<Integer> hs = new HashSet<>();
        int count = 0;
        for(int i : freqCount){
            while(i != 0 && hs.contains(i)){
                i--;
                count++;
            }
            hs.add(i);
        }
        return count;
    }
}