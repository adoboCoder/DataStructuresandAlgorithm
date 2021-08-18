import java.util.*;

class LCM_322ReconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        
        for(List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        
        LinkedList<String> result = new LinkedList<>();
        dfs(adj, result, "JFK");
        return result;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> adj, LinkedList<String> result, String s) {
        PriorityQueue<String> pq = adj.get(s);
        
        while(pq != null && !pq.isEmpty()) {
            String v = pq.poll();
            dfs(adj, result, v);
        }
        result.addFirst(s);
    }

    public static void main(String[] args) {
        List<List<String>> list = asList(asList("MUC", "LHR"), asList("JFK", "MUC"), asList("MUC", "LHR"),
                asList("JFK", "MUC"), asList("SFO", "SJC"), asList("LHR", "SFO"), asList("JFK", "SFO"),
                asList("JFK", "ATL"), asList("SFO", "ATL"), asList("ATL", "JFK"), asList("ATL", "SFO"));

        System.out.println(LCM_322ReconstructItinerary.findItinerary(list));
    }
}