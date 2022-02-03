import java.util.*;
class LCM_133CloneGraph {
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }
    
    public static Node dfs(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone); // map OLD node to NEW node!
        for (Node nei : node.neighbors)
            clone.neighbors.add(dfs(nei, map));
        return clone;
    }
}
