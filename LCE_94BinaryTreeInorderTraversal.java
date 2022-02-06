import java.util.*;

class LCE_94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        Stack <TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list; //Iterative method

    }

    public static List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    public static void dfs(TreeNode root, List<Integer> result) {
        if(root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
}