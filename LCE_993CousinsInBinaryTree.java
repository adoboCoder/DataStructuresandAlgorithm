class LCE_993CousinsInBinaryTree {
    static TreeNode xParent = null;
    static TreeNode yParent = null;
    static int xDepth = -1;
    static int yDepth = -1;

    public static boolean isCousins(TreeNode root, int x, int y) {
        getDepth(root, x, y, 0 ,null);
        return xDepth == yDepth && xParent != yParent ? true : false;
    }
    private static void getDepth(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null) {
            return;
        }

        if(root.val == x) {
            xParent = parent;
            xDepth = depth; 
        }
        else if(root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        getDepth(root.left, x, y, depth + 1, root);
        getDepth(root.right, x, y, depth + 1, root);
    }
}