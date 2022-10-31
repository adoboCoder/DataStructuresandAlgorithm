import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class LCM_133CloneGraph {
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }
    
    public static Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone); // map OLD node to NEW node!
        for (Node nei : node.neighbors)
            clone.neighbors.add(dfs(nei, map));
        return clone;
    }
}

// TC O(N + M) where N is a number of nodes (vertices) and M is a number of edges.
// SC O(N)
