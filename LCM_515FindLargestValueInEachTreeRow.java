import java.util.*;

class LCM_515FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null)
            return;

        if (depth == result.size()) {
            result.add(root.val);
        } else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }

        dfs(root.left, result, depth + 1);
        dfs(root.right, result, depth + 1);
    }
}