class  Solution{
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int min, int max){
        if(root == null){
            return max - min;
        }
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        return Math.max(dfs(root.left, min, max),dfs(root.right, min, max));
    }
}