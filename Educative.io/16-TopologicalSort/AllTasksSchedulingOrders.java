import java.util.*;

class AllTasksSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(tasks <= 0) return;

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < tasks; i++) {
            indegree.put(i, 0);
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            adjList.get(parent).add(child);// put the child into it's parent's list
            indegree.put(child, indegree.get(child) + 1); // increment child's inDegree
        }
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        printAllTopologicalSorts(adjList, indegree, q, sortedOrder);
    }
    public static void printAllTopologicalSorts(Map<Integer, List<Integer>> adjList, Map<Integer, Integer> indgree, 
    Queue<Integer> q, List<Integer> sortedOrder) {
        
    }

}