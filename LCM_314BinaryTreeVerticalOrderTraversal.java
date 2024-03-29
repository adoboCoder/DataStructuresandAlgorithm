import java.util.*;

class LCM_314BinaryTreeVerticalOrderTraversal {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if(node.left != null){
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if(node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(LCM_314BinaryTreeVerticalOrderTraversal.verticalOrder(root));


    }
}

// Tc: O(n) n # of nodes
// Sc: O(n) 