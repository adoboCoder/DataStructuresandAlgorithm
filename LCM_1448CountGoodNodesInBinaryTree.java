class Solution{
    int good;
    public int goodNodes(TreeNode root){
        good = 0;
        int max = Integer.MIN_VALUE;
        helper(root, max);
<<<<<<< HEAD

        return good;
    }

=======
        return good;
    }
    
>>>>>>> 3ec19f95e8b4c3416fbf52d69af07fd5599c7bef
    public void helper(TreeNode root, int max){
        if(root == null){
            return;
        }
<<<<<<< HEAD
=======
        
>>>>>>> 3ec19f95e8b4c3416fbf52d69af07fd5599c7bef
        if(root.val >= max){
            good++;
        }
        max = Math.max(max, root.val);
<<<<<<< HEAD
        helper(root.right, max);
        helper(root.left, max);
=======
        helper(root.left, max);
        helper(root.right, max);
>>>>>>> 3ec19f95e8b4c3416fbf52d69af07fd5599c7bef
    }
}

//Time O(n)
<<<<<<< HEAD
//Sapce O(Height)
=======
//Space O(h)
>>>>>>> 3ec19f95e8b4c3416fbf52d69af07fd5599c7bef
