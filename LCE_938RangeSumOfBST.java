class Solution{
    public int rangeSumBST(TreeNode root, int L, int R){
        if(root == null) return 0;
        
        //Check if root is less than Left limit, disregard the left children, pass in the right child recursively
        if(root.val < L) return rangeSumBST(root.right, L, R);
        //Check if root is greater than Left limit, disregard the right children, pass in the right child recursively
        if(root.val > R) return rangeSumBST(root.left, L, R);
        //If root is not out of bounds (between left and right), add to the sum of rangeSumBST(root.left, L, R) and rangeSumBST(root.right, L, R)
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}

