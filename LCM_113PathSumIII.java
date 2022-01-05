
import java.util.*;
class LCM_113PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
        dfs(root, targetSum, current, result);
        return result;
    }

    private static void dfs(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result) {
        if (root == null)
            return;

        current.add(root.val);

        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(current));
        } else {

            dfs(root.left, targetSum - root.val, current, result);
            dfs(root.right, targetSum - root.val, current, result);
        }
        current.remove(current.size() - 1);
    }
}