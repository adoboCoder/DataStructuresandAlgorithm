import java.util.*;

class LCH_124BinaryTreeMaximumPathSum {
    public int globalMax;
    public static int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }
    public static int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int maxLeftRight = Math.max(left, right);
        int maxRoot = Math.max(maxLeftRight + root.val, root.val);
        int maxAll = Math.max(maxRoot, left + right + root.val);
        globalMax = Math.max(globalMax, maxAll);
        return maxRoot;

    }
}