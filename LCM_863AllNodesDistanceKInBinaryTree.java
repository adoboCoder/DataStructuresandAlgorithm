import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LCM_863AllNodesDistanceKInBinaryTree {
            
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        if (K == 0) {
            result.add(target.val);
        } else {
            dfs(result, root, target.val, K ,0);
        }
        return result;
    }
    
    private int dfs(List<Integer> result, TreeNode node, int target, int K, int depth) {
        if (node == null) return 0;
        
        if (depth == K) {
            result.add(node.val);
            return 0;
        }
        
        int left;
        int right;
        if (node.val == target || depth > 0) {
            left = dfs(result, node.left, target, K, depth + 1);
            right = dfs(result, node.right, target, K, depth + 1);
        } else {
            left = dfs(result, node.left, target, K, depth);
            right = dfs(result, node.right, target, K, depth);
        }
        
        if (node.val == target) return 1;
        
        if (left == K || right == K) {
            result.add(node.val);
            return 0;
        }
        
        if (left > 0) {
            dfs(result, node.right, target, K, left + 1);
            return left + 1;
        }
        
        if (right > 0) {
            dfs(result, node.left, target, K, right + 1);
            return right + 1;
        }
        
        return 0;
    }
}

// TC O(N)
// SC O(