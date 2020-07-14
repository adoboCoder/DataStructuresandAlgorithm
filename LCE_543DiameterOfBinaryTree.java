class Solution{
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

// Time O(h)  where h is the height of the tree