class Solution{
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        return isValid (root, false, 0, false, 0);
    }

    private boolean isValid(TreeNode root, boolean hasMax, int max, boolean hasMin, int min) {
        if(root == null){
            return true;
        }
        else{
            if(hasMax){
                if(root.val >= max){
                    return false;
                }
            }
            if(hasMin){
                if(root.val <= min){
                    return false;
                }
            }
        }
        return isValid(root.left, true, root.val, hasMin, min) &&  isValid(root.right, hasMax, max, true, root.val); 
    }
}