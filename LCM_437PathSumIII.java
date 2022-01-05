
class Solution {
    public int pathSum(TreeNode root, int sum) {
      if (root == null){
          return 0;
      }
    return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int dfs(TreeNode root, int sum, int current) {
    if (root == null){
        return 0;
    }
    current += root.val;
    return (current == sum ? 1 : 0) + dfs(root.left, sum, current) + dfs(root.right, sum, current);
  }
}