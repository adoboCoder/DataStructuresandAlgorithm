import java.util.*;

class LCM_426ConvertBinarySearchTreeToSortedDoublyLinkedList{
    public static Node treeToDoublyList(Node root) {
        Node prev = null;
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    
    private static void helper (Node cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }
}