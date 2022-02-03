class LCM_1522DiameterOfNAryTree {
    int result = 0;    
    public static int diameter(Node root) {
        getHeight(root);
        return result;
    }
    public static int getHeight(Node root) {
            if(root == null) return 0;
            int max = 0;
            
            for(Node child : root.children) {
                int height = getHeight(child);
                result = Math.max(result, max + height);
                max = Math.max(max, height);
            }
            return max + 1;
    }
}