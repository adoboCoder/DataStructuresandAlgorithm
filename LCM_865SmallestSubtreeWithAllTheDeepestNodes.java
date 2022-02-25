class LCM_865SmallestSubtreeWithAllTheDeepestNodes {
    public static int  deepestLevel = 0;
    public static TreeNode result = null;
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private static int dfs(TreeNode root, int level) {
        if(root == null) return level;

        int left = dfs(root.left, level + 1);
        int right = dfs(root.right, level + 1);

        int currentLevel = Math.max(left, right);
        deepestLevel = Math.max(deepestLevel, currentLevel);
        if(left == deepestLevel && right == deepestLevel) {
            result = root;
        }
        return currentLevel;
    }
}