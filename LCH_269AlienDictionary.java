import java.util.*;
class LCH_269AlienDictionary {
    public static String alienOrder(String[] words) {
        
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.put(c,0);
            }
        }
        for(int i = 1; i < words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            if(word1.length()>word2.length() && word1.startsWith(word2)){
                return "";
            }
            for(int k = 0 ; k< Math.min(word1.length(), word2.length()); k++){
                char c1 = word1.charAt(k);
                char c2 = word2.charAt(k);
                
                if(c1 != c2){
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2)+1);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e: inDegree.entrySet()){
            if(e.getValue()==0){
                q.add(e.getKey());
            }
        }
        while(!q.isEmpty()){
            char cur = q.remove();
            sb.append(cur);
            for(char nei : adj.get(cur)){
                inDegree.put(nei, inDegree.get(nei)-1);
                if(inDegree.get(nei) == 0){
                    q.add(nei);
                }
            }
        }
        if(inDegree.size() > sb.length()){
            return "";
        }
        return sb.toString();
    }

        public static void main(String[] args) {
            String[] words = {"awzwwim","wrt", "wrf", "er", "ett", "rftt"};
            System.out.println(LCH_269AlienDictionary.alienOrder(words));
        }

}