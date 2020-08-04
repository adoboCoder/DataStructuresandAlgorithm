class Solution {
    public int closestValue(TreeNode root, double target) {
    int a = root.val;
    TreeNode child = target < a ? root.left : root.right;
    if (child == null){
      return a;   
    }
    int b = closestValue(child, target);
    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}