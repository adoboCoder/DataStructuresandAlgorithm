import java.util.*;

class Node {
    public static int val;
    public static List<Node> neighbors;
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
    public static HashMap<Integer, Node> map = new HashMap<>();
    
    public static Node cloneGraph(Node node) {
        return clone(node);
    }

    public static Node clone(Node node) {
        if(node == null) return null;

        if(map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);

        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }
}
