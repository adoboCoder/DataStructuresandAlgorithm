class Solution {
    
    int deepestLevel = 0;
    TreeNode result = null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    
    private int dfs(TreeNode root, int level) {
        if (root == null){
            return level;
        } 
            
        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);
        
        int currentLevel = Math.max(leftLevel, rightLevel);
        deepestLevel = Math.max(deepestLevel, currentLevel);
        if (leftLevel == deepestLevel && rightLevel == deepestLevel){
            result = root;
        }
        return currentLevel;
    }
}