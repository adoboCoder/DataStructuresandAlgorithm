import java.util.*;

class LCM_1650LowestCommonAncestorIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

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
        System.out.println();
    }
}