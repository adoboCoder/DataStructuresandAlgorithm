import java.util.*;
class LCH_124BinaryTreeMaximumPathSum {
    private static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum; // as maxSum will always store the result
    }
    public static int dfs(TreeNode root) {
        if (root == null) return 0; 
		
		// recursing through left and right subtree
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

		// finding all the four paths and the maximum between all of them
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);
		
		// Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, maxAll);
		
		// returning the value if root was part of the answer
        return maxOneNodeRoot;
    }
}