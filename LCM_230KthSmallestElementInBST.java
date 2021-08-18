// better keep these two variables in a wrapper class
class LCM_230KthSmallestElementInBST {
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int KthSmallest(TreeNode root, int k){
        traverse(root, k);
        return result;
    }
    public void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        traverse(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
        }
        traverse(root.right, k);
    }
}