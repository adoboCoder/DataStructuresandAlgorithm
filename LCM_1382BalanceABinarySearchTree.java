import java.util.*;

class LCM_1382BalanceABinarySearchTree {

    public static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> sortedArr = new ArrayList<>();
        inorderTraverse(root, sortedArr);
        return sortedArrayToBST(0, sortedArr.size() - 1, sortedArr);
    }

    public static void inorderTraverse(TreeNode root, List<TreeNode> sortedArr) {
        if (root == null)
            return;
        inorderTraverse(root.left, sortedArr);
        sortedArr.add(root);
        inorderTraverse(root.right, sortedArr);
    }

    public static TreeNode sortedArrayToBST(int start, int end, List<TreeNode> sortedArr) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1, sortedArr);
        root.right = sortedArrayToBST(mid + 1, end, sortedArr);
        return root;
    }
}