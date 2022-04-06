class LCE_270ClosestBinarySearchTreeValue {
    public static int closestValue(TreeNode root, double target) {
      int a = root.val;
      TreeNode child = target < a ? root.left : root.right;
      if (child == null){
        return a;
      }
      int b = closestValue(child, target);
      return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
  public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      System.out.println(closestValue(root, 3.714286));
  }
}
// tc O(H) 
// sc O(1)