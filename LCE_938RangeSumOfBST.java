class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(root.val > low) { 
            sum = sum + rangeSumBST(root.left, low, high);
        }
        if(root.val < high) {
            sum = sum + rangeSumBST(root.right, low, high);
        }
        if(root.val >= low && root.val <= high) {
            sum = sum + root.val;
        }
        return sum;
    }
}