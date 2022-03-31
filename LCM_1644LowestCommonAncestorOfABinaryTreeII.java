/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class LCM_1644LowestCommonAncestorOfABinaryTreeII {
    static int count = 0;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = lca(root, p, q);
        return count == 2 ? result : null;
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(root == p || root == q) {
            count++;
            return root;
        }
        return left == null ? right : right  == null ? left : root;
    }
}
/*
Time Complexity: O(N)
Space Complexity: O(H), H is the height of the tree

*/