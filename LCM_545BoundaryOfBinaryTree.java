class Solution{
    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root  != null){
            result.add(root.val);
            helper(root.left, result, true, false);
            helper(root.right, result, false, true);
        }
        return result;
    }

    public void helper(TreeNode root, List<Integer> result, boolean isLeft, boolean isRight){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }

        if(isLeft){
            result.add(root.val);
        }

        helper(root.left, result, root.left != null && isLeft, root.right == null && isRight);
        helper(root.right, result, root.left == null && isLeft, root.right != null && isRight);

        if(isRight){
            result.add(root.val);
        }
    }
}