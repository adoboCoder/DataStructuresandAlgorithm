class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    dfs("", result, n, n);
    return result;
}
    private void dfs(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            dfs( sublist + "(" , list, left - 1, right);
        }
        if(right > 0){
            dfs( sublist + ")" , list, left, right - 1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }
}

/*
Time: O(n)
Space: O(n)

*/