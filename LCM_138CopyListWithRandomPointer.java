import java.util.*;

public class LCM_138CopyListWithRandomPointer {
    Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        if (this.visited.containsKey(head)) {
            return this.visited.get(head);
        }

        this.visited.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }
}