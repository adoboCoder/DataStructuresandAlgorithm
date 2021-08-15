import java.util.*;
class LCH_269AlienDictionary {
    public static  String alienOrder(String[] words) {

        //Setup datatstructures to find all unique words
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        String result = "";
        if(words == null || words.length == 0) return result;
        for(String word: words){
            for(char c: word.toCharArray()){
                degree.put(c,0);
            }
        }

        // find all edges
        for(int i = 0; i < words.length - 1; i++){
            String currentWord = words[i];
            String nextWord = words[i+1];
            int length = Math.min(currentWord.length(), nextWord.length());
            if(currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)){
                return "";
            }
            for(int j = 0; j < length; j++){
                char char1 = currentWord.charAt(j); //Char1 is the pointer to currentWord
                char char2 = nextWord.charAt(j); //Char2 is the pointer to nextWord
                if(char1 != char2){
                    Set<Character> set = new HashSet<Character>();
                    if(map.containsKey(char1)){
                        set = map.get(char1);
                    }
                    if(!set.contains(char2)){
                        set.add(char2);
                        map.put(char1, set);
                        degree.put(char2, degree.get(char2)+1);
                    }
                    break;
                }
            }
        }
        
        // bfs
        Queue<Character> q = new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c) == 0){
                q.add(c);
            } 
        }
        while(!q.isEmpty()){
            char c = q.remove();
            result += c;
            if(map.containsKey(c)){
                for(char char2: map.get(c)){
                    degree.put(char2,degree.get(char2) - 1);
                    if(degree.get(char2) == 0) q.add(char2);
                }
            }
        }
        if(result.length() != degree.size()) return "";
        return result;
        }

        public static void main(String[] args) {
            String[] words = {"awzwwim","wrt", "wrf", "er", "ett", "rftt"};
            System.out.println(LCH_269AlienDictionary.alienOrder(words));
        }

}