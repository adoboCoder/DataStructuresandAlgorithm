import java.util.*;

class LCM_1123LowestCommonAncestorOfDeepestLeaves {

    HashMap<TreeNode, Integer> heights = new HashMap<TreeNode,Integer>();
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null || height(root.right)==height(root.left))return root;
        return lcaDeepestLeaves(height(root.left)>height(root.right)?root.left:root.right);
    }
    
    public int height(TreeNode root){
        if(root==null)return 0;
        if(heights.containsKey(root))return heights.get(root);
        heights.put(root,1 + Math.max(height(root.left),height(root.right)));
        return heights.get(root);
    }
}