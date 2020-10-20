public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //handle bad input       
        if(prerequisites == null || numCourses == 0 || prerequisites.length == 0){
           return true;
       }
        //set up adjacency list
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        
        for(int[] req: prerequisites){
            map.get(req[1]).add(req[0]);
            //directed graph, so only one-way
        }
        
        // created a visited array where 0 = visited, -1 = visiting, 1 = visited
        int[] visited = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                //false if a cycle is found
                if(!dfs(map, visited, i)){
                    return false;
                }
            }
        //if no cycle is found return true;
        return true;
    }
    
    private boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int i){
        //if we run into a node that we saw earlier in this CURRENT dfs, it's a cycle
        if(visited[i] == -1){
            return false;
        }
        
        // if we run into a node that we saw in a seperate earlier dfs, there's no problem
        if(visited[i] == 1){
            return true;
        }
        
        //mark the current node as -1 (visiting)
        visited[i] = -1;
        if(map.containsKey(i)){
            //get all the neighbors of this node
            for(int j : map.get(i)){
                //dfs into its neighbors and return false if cycle was found
                if(!dfs(map, visited, j)){
                    return false;
                }
            }
        }
        
        //if all its neighbors were visted and there are no issues,
        // we're done with this node and we mark it as 1 (done visiting)
        visited[i] = 1;
        return true;
    }
}
/*
This is a cycle detection problem.  The problem is solved by running a dfs in a directed graph (arrows pointing from node-to-done).  
For example, n = 5 prerequisites[][] = [[0,1], [1,2], [3,2], [4,3], [2,4]]

To take course 0, course 1 must be taken first.
To take course 1, course 2 must be taken first.
To take course 3, course 2 must be taken first.
To take course 4, course 3 must be taken first.
To take course 2, course 4 must be taken first.

0<-1
1<-2
3<-2
4<-3
2<-4

The pattern for these types of problem is to build an adjacency list first.  This is accomplished by using a HashMap<Integer, ArrayList<Ingetger>>.
The key for the HashMap will be the course that we would like to take, and the value would be all the courses that depend on.

Map would look like this: 

{0:[],1:[0],2:[1,3],3:[4],4:[2]}

Then we create a visted array with the size of the number of courses.  The array data type is int because we will be assigning it with the following format:
0 => unvisited
-1 => visiting
1 => visited


*/