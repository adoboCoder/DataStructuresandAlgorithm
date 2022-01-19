import java.util.*;

class xTreeNode {
    int val;
    xTreeNode left;
    xTreeNode right;

    xTreeNode() {
    }

    xTreeNode(int val) {
        this.val = val;
    }

    xTreeNode(int val, xTreeNode left, xTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LCM_366FindLeavesOfBinaryTree {

    public static List<List<Integer>> findLeaves(xTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static int dfs(xTreeNode root, List<List<Integer>> result) {
        if (root == null)
            return -1;

        int level = 1 + Math.max(dfs(root.left, result), dfs(root.right, result));
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        return level;
    }

    public static void main(String[] args) {
        xTreeNode root = new xTreeNode(1);
        root.left = new xTreeNode(2);
        root.right = new xTreeNode(3);
        root.left.left = new xTreeNode(4);
        root.left.right = new xTreeNode(5);

        System.out.println(LCM_366FindLeavesOfBinaryTree.findLeaves(root));
    }
}

// Time: O(N)
// Space: O(N)