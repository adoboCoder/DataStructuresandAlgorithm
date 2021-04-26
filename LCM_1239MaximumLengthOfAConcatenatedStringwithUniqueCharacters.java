class Solution{
    private int result = 0;

    public int maxLength(List<String> arr){
        if(arr == null || arr.size() == 0){
            return 0;
        }
        dfs(arr, "", 0);
        return result;
    }

    public void dfs(List<String> arr, String path, int index){
        boolean isUniqueChar = isUniqueCharacter(path);

        if(isUniqueChar){
            result = Math.max(path.length(), result);
        }

        if(index == arr.size() || !isUniqueChar){
            return;
        }

        for(int i = index; i < arr.size(); i++){
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    public boolean isUniqueCharacter(String str) {
        Set<Character> hs = new HashSet<>();

        for(char c : str.toCharArray()){
            if(!hs.add(c)){
                return false;
            }
            hs.add(c);
        }
        return true;
        
    }
}
