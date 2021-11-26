import java.util.*;
    class myTreeNode {
        int val;
        myTreeNode left;
        myTreeNode right;
        myTreeNode() {}
        myTreeNode(int val) {
            this.val = val;
        }
        myTreeNode(int val, myTreeNode left, myTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


class LCM_652FindDuplicateSubtrees {
    
    public static List<myTreeNode> findDuplicateSubtrees(myTreeNode root) {
        Map<String, List<myTreeNode>> map = new HashMap<>();
        List<myTreeNode> result = new  ArrayList<>();

        helper(root, map);
        for(List<myTreeNode> group : map.values()) {
            if(group.size() > 1 ) {
                result.add(group.get(0));
            }
        }
        return result;
    }

    private static String helper(myTreeNode node, Map<String, List<myTreeNode>> map){
        if(node == null) {
            return "";
        }

        String output = "(" + helper(node.left, map) + node.val + helper(node.right, map) + ")";
        if(!map.containsKey(output)) {
            map.put(output, new ArrayList<myTreeNode>());
        }
        map.get(output).add(node);
        return output;
    }

    public static void main(String[] args) {
        myTreeNode root = new myTreeNode(1);
        root.left = new myTreeNode (2);
        root.right = new myTreeNode(3);
        root.left.left = new myTreeNode(4);
        root.right.right = new myTreeNode(4);
        root.right.left = new myTreeNode(2);
        root.right.left.left = new myTreeNode(4);
        List<myTreeNode> result = LCM_652FindDuplicateSubtrees.findDuplicateSubtrees(root);
        for(myTreeNode i : result) {
            System.out.println(i.val);
        }
    }
}