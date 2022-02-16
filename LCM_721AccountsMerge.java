import java.util.*;

class LCM_721AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
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
        List<List<String>> result = new ArrayList<>();
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
    
    public static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john_newyork@mail.com");
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john00@mail.com");
        List<String> list3 = new ArrayList<>();
        list3.add("Mary");
        list3.add("mary@mail.com");
        List<String> list4 = new ArrayList<>();
        list4.add("John");
        list4.add("johnnybravo@mail.com");
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);

        System.out.println(accountsMerge(accounts));
    }
}
/*

N is the number of accounts and K is the maximum length of an account.

Time complexity: O(NK log NK)
Space complexity: O(NK)O(NK)

*/