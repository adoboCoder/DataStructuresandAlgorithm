
// 116. Populating Next Right Pointers in Each Node
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ 
import java.util.*;
    class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}
    public Node (int _val) {
        val = _val;
    }

    public Node (int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
class LCM_116PopulatingNextRightPointersInEachNode{
    public Node connect (Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node root, Node next) {
        if(root == null) {
            return;
        }
        root.next = next;

        dfs(root.left, root.right);
        dfs(root.right, root.next == null ? null : root.next.left);
    }
}