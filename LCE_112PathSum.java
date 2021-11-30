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

class LCE_112PathSum {
    public static boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return target == root.val;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val)
    }
}