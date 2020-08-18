public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return result;
        }
        int[] hash = new int[256]; // Character Hash

        for(char c : p.toCharArray()){
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right < s.length()){
            //Move right everytime, if the character exists in P's Hash, decrease the count
            //current has value of >=1 means the character is existing in p
            if(hash[s.charAt(right)]>= 1){
                count--;
            }

            hash[s.charAt(right)]--;
            right++;

            // When the count is down to zero, means we found the right anagram
            // then add the left index to the result list.
            if(count == 0){
                result.add(left);
            }

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to  reset the hash because we kicked out he left
            //only increase the count if the character is in p
            // count >= 0 indicates it was original in the hash because it won't go below zero.
            if(right - left == p.length()){
                if(hash[s.charAt(left)] >= 0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}