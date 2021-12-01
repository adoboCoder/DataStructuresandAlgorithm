import java.util.*;

class LCH_322ReconstrucItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs(adjList, "JFK", result);
        return result;
    }

    private static void dfs(Map<String, PriorityQueue<String>> adjList, String current, List<String> result) {
        PriorityQueue<String> pq = adjList.get(current);

        while (pq != null && !pq.isEmpty()) {
            String v = pq.poll();
            dfs(adjList, v, result);
        }
        result.add(0, current);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("MUC");
        temp.add("LHR");
        tickets.add(temp);
        temp = new ArrayList<>();
        temp.add("JFK");
        temp.add("MUC");
        tickets.add(temp);
        temp = new ArrayList<>();
        temp.add("SFO");
        temp.add("SJC");
        tickets.add(temp);
        temp = new ArrayList<>();
        temp.add("LHR");
        temp.add("SFO");
        tickets.add(temp);

        System.out.println(LCH_322ReconstrucItinerary.findItinerary(tickets));
    }

}