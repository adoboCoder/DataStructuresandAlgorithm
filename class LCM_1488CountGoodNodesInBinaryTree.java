class LCM_1488CountGoodNodesInBinaryTree{
    public static int countGoodNodes(TreeNode root) {
        return preorder(root, root.val);
    }
    public static int preorder(TreeNode n, int v) {
        if(n == null) return 0;

        int max = Math.max(n.val, v);
        return(n.val >= v ? 1 : 0) + preorder(n.left, max) + preorder(n.right, max);
    }
}