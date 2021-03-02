class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> hs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            if(!hs.contains(s.charAt(i))){
                hs.add(s.charAt(i));
            }
            else{
                hs.remove(s.charAt(i));
            }
        }
        return hs.size() == 1 || hs.size() == 0;
    }
}