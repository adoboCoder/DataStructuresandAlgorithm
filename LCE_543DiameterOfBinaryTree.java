
class LCE_543DiameterOfBinaryTree{
  public static int max = 0;
  public static int diameterOfBinaryTree(TreeNode root) {
       maxDepth(root);
       return max;
  }

  public static int maxDepth(TreeNode root){
      if(root == null){
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
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    System.out.println("Tree Diameter: " + LCE_543DiameterOfBinaryTree.diameterOfBinaryTree(root));
    root.left.left = null;
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    root.right.left.right.left = new TreeNode(10);
    root.right.right.left.left = new TreeNode(11);
    System.out.println("Tree Diameter: " + LCE_543DiameterOfBinaryTree.diameterOfBinaryTree(root));
  }
}