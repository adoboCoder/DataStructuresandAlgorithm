// better keep these two variables in a wrapper class
class Solution{
    
private static int number = 0;
  private static int target = 0;

  public int kthSmallest(TreeNode root, int k) {
      target = k;
      helper(root);
      return number;
  }
  
  public void helper(TreeNode n) {
      if (n.left != null) helper(n.left);
      target--;
      if (target == 0) {
          number = n.val;
          return;
      }
      if (n.right != null) helper(n.right);
  }
}