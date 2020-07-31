class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
        return list;
    }
}