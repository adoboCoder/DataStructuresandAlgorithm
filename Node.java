public class Node {
    public  int val;
    public Node left;
    public Node right;
    public Node parent;
    public Node(int val) {
        this.val = val;
        this.left = this.right = this.parent = null;
    }
}