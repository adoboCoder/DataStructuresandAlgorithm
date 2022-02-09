import java.util.*;

class LCM_721AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);
                
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {
            List<String> list = new ArrayList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                result.add(list);
            }
        }
        
        return result;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
}
/*

N is the number of accounts and K is the maximum length of an account.

Time complexity: O(NK log NK)O(NKlogNK)
Space complexity: O(NK)O(NK)

*/