import java.util.*;

class LCM_536ConstructBinaryTreeFromString {
    public static TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if (c == ')')
                stack.pop();
            else if (c >= '0' && c <= '9' || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i++;
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null)
                        parent.right = currentNode;
                    else
                        parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}