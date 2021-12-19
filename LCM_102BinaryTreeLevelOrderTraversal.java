import java.util.*;

class LCM_102BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                temp.add(node.val);
            

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode (3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(LCM_102BinaryTreeLevelOrderTraversal.levelOrder(root));
    }
}