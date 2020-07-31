class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack <TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}