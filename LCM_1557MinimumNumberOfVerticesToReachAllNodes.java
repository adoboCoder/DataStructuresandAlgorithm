class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer, Integer> indegree = new  HashMap<>();
        
        for(List<Integer> edge : edges){
            int end = edge.get(1);
            indegree.put(end, indegree.getOrDefault(end, 0) + 1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(!indegree.containsKey(i)){
                result.add(i);
            }
        }
        return result;
    }
}

/*
The idea is to build an indegree haspmap with the following properties:

Key: Node's data
Value: Count of incoming edges

With example 
edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
n = 6

the indgree hashmap will be the following: 
indegree: {1:1,2:2,4:1,5:1}

Once the indegree hashmaps has been contructed, we loop through the indegree hashmap from 0 to n; in this case 0-5
if the indegree does NOT contain the key 0-5.  Then we would add the value of the node (Node's data) to the result set.

Time: O(n) where N is the number of edges
Space: O(n)


*/
