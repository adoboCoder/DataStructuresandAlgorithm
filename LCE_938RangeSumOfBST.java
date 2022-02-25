import java.util.*;
class LCE_938RangeSumOfBST {
    
    public static int rangeSumBST(TreeNode root, int low, int high) {
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        System.out.println(rangeSumBST(root, 7, 15));
    }
}

/*
Time: O(n), space: O(h)
*/