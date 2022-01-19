class LCM_2096StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public static String getDirections (TreeNode root, int startValue, int destValue) {
        StringBuilder source = new StringBuilder();
        StringBuilder dest = new StringBuilder();

        findDirectionFromRoot(root, startValue, source);
        findDirectionFromRoot(root, destValue, dest);

        
        int minLen = Math.min(source.length(), dest.length());
        int i = 0;
        while(i < minLen && source.charAt(source.length() - i - 1) == dest.charAt(dest.length() - i - 1)) {
            i++;
        }

        return "U".repeat(source.length() - i) + dest.reverse().toString().substring(i);
    }

    public static boolean findDirectionFromRoot(TreeNode node, int val, StringBuilder sb) {
        if(node.val == val) {
            return true;
        }
        if(node.left != null && findDirectionFromRoot(node.left, val, sb)) {
            sb.append("L");
        }
        else if(node.right != null && findDirectionFromRoot(node.right, val, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }
}


/*
1. Build directions for both start and destination from the root.
    Say we get "LLRRL" and "LRR".
2. Remove common prefix path.
    We remove "L", and now start direction is "LRRL", and destination - "RR"
3. Replace all steps in the start direction to "U" and add destination direction.
    The result is "UUUU" + "RR".
*/
