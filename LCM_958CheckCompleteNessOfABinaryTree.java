class LCM_958CheckCompletenessOfABinaryTree {
    public static boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root,0,countNodes(root));
    }
    private static boolean isCompleteTree(TreeNode root, int index, int total) { 
        if (root == null)  return true; 
        else if (index >= total) return false; 
        return isCompleteTree(root.left, 2 * index + 1, total) && isCompleteTree(root.right, 2 * index + 2, total); 
    } 
    private static int countNodes(TreeNode root) { 
        if (root == null) return 0; 
        return 1 + countNodes(root.left) + countNodes(root.right); 
    } 
}