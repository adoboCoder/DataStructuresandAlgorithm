import java.util.*;
class LCM_1650LowestCommonAncestorIII {
    public static class Node {
        public  int val;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val) {
            this.val = val;
            this.left = this.right = this.parent = null;
        }
    }
    public static Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = p.parent;
        }

        while(!set.contains(q)) {
            q = q.parent;
        }

        return q;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        Node p = root.left.left;
        Node q = root.right.right;
        System.out.println(lowestCommonAncestor(p, q));
    }
}
/*
Time Complexity: O(h)
Space Complexity: O(1)
*/