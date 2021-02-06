class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
      Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains){
            int i = s.indexOf(' ');
            int n = Integer.valueOf(s.substring(0, i));
            String str = s.substring(i + 1);
            for(i = 0; i < str.length(); i++){
                if(str.charAt(i) == '.'){
                    String d = str.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(str, map.getOrDefault(str, 0) + n);
        }
        List<String> result = new ArrayList<>();
        
        for(String m : map.keySet()){
            result.add(map.get(m) + " " + m);
        }
        return result;
    }
}