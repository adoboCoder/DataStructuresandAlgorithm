class NodeInBinaryTree {
    public static boolean NodeExistInBinaryTree(TreeNode root, int key) {
        if(root == null) return false;
        if(root.val == key) return true;
        return NodeExistInBinaryTree(root.left, key) || NodeExistInBinaryTree(root.right, key);
    }
}