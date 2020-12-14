class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> oneMap = new HashMap<>();
        HashMap<Character, Integer> twoMap = new HashMap<>();
        
        for(char c : word1.toCharArray()){
            oneMap.put(c, oneMap.getOrDefault(c, 0) + 1);
        }
        
        for(char c : word2.toCharArray()){
            twoMap.put(c, twoMap.getOrDefault(c, 0) + 1);
        }
        
        if (!oneMap.keySet().equals(twoMap.keySet())) {
		return false;
	    }
        
        List<Integer> word1FreqList = new ArrayList<>(oneMap.values());
        List<Integer> word2FreqList = new ArrayList<>(twoMap.values());
        
        Collections.sort(word1FreqList);
        Collections.sort(word2FreqList);
        
        return word1FreqList.equals(word2FreqList);
        
    }
}
