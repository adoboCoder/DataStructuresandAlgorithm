class LCM_2096StepByStepDirectionsFromABinaryTreeNodeToAnother {
    private static boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val)
            return true;
        if (n.left != null && find(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && find(n.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder source = new StringBuilder();
        StringBuilder destination = new StringBuilder();
        find(root, startValue, source);
        find(root, destValue, destination);
        int i = 0;
        int maxLength = Math.min(destination.length(), source.length());
        while (i < maxLength
                && source.charAt(source.length() - i - 1) == destination.charAt(destination.length() - i - 1))
            ++i;
        return "U".repeat(source.length() - i) + destination.reverse().toString().substring(i);
    }
}