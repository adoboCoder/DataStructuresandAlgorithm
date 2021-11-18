import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        helper(result, root, 0);
        return result;
    }
    
    public void helper(List<Integer> result, TreeNode root, int depth){
        if(root == null){
            return;
        }
        if( depth == result.size())
        result.add(root.val);
        
        helper(result, root.right, depth +1);
        helper(result, root.left, depth +1);
    }
}