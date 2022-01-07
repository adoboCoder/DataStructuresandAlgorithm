import java.util.*;

class LCM_1650LowestCommonAncestorIII {
    
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
}