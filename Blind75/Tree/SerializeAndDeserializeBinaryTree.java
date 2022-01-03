import java.util.*;

package Blind75.Tree;

public class SerializeAndDeserializeBinaryTree {
    public class Codec {
        private static final String splitter = ",";
        private static final String nullNode = "null";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(splitter)));
            return buildTree(nodes);
        }
        
        private void buildString(TreeNode root, StringBuilder sb){
            if(root == null) {
                sb.append(nullNode).append(splitter);
            }
            else {
                sb.append(root.val).append(splitter);
                buildString(root.left, sb);
                buildString(root.right, sb);
            }
        }
        
        private TreeNode buildTree(Deque<String> nodes) {
            return null;
        }
        
    }
}
