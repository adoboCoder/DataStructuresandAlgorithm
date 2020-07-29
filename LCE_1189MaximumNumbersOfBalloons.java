class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        
        for(char c : text.toCharArray()){
            freq[c - 'a']++;
        }
        int min = freq[1];//for b
        min = Math.min(min, freq[0]);//for a
        min = Math.min(min, freq[11] / 2);// for l /2 
        min = Math.min(min, freq[14] / 2);//similarly for o/2
        min = Math.min(min, freq[13]);//for n
        return min;
    }
}