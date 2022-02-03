
class LCM_129SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int currentSum) {
        if (root == null)
            return 0;

        currentSum = currentSum * 10 + root.val;
        if(root.right == null && root.left == null) return currentSum;
        int left = dfs(root.left, currentSum);
        int right = dfs(root.right, currentSum);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);

        System.out.println(LCM_129SumRootToLeafNumbers.sumNumbers(root));

    }
}