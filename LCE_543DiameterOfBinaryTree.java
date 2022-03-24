class LCE_543DiameterOfBinaryTree {
  public static int max = 0;

  public static int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return max;
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    max = Math.max(max, left + right);

    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    
    System.out.println("Tree Diameter: " + LCE_543DiameterOfBinaryTree.diameterOfBinaryTree(root));
  }
}

// TC: O(n)
// SC: O(n), but if the tree is balanced it'd be O(log N)
