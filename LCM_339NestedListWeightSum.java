import java.util.*;

class LCM_339NestedListWeightSum {
    public int depthSum_BFS(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> q = new LinkedList<NestedInteger>(nestedList);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                NestedInteger ni = q.poll();
                
                if(ni.isInteger()){
                    sum += ni.getInteger() * level;
                }else{
                    q.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }
    public int depthSumDFS(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    private int dfs(List<NestedInteger> list, int depth) {
        int total = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                total += nested.getInteger() * depth;
            } else {
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;
    }

}