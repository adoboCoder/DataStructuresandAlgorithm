class Solution{
    int good;
    public int goodNodes(TreeNode root){
        good = 0;
        int max = Integer.MIN_VALUE;
        helper(root, max);

        return good;
    }

    public void helper(TreeNode root, int max){
        if(root == null){
            return;
        }
        
        if(root.val >= max){
            good++;
        }
        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}

//Time O(n)
//Space O(h)
