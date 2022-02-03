
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;

        while (prev.next != head) {
            if (prev.val <= insertVal && insertVal <= curr.val)
                break;
            else if (prev.val > curr.val && (insertVal > prev.val || insertVal < curr.val)) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        Node newNode = new Node(insertVal);
        newNode.next = curr;
        prev.next = newNode;

        return head;
    }
}