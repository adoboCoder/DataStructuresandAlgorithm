<<<<<<< HEAD
public Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0){
                indegree[ready]++; //duplicate case
            }
            matrix[pre][ready] = 1;
=======
public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        int[] inDegree = buildInDegreeArray(numCourses,prerequisites);
        Queue<Integer> queue = new LinkedList<>();

        //Find al lthe courses that have no prerequisites on them from the start, and them to the queue.
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
>>>>>>> 087f56e9e775a897a248a3a37a102192715aa396
        }
        int count = 0;
<<<<<<< HEAD
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            } 
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0){
                        queue.offer(i);
                    }
=======
        while(!queue.isEmpty()){
            int currentCourse  = queue.poll();
            count++;
            for(int neighbor : map.get(currentCourse)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
>>>>>>> 087f56e9e775a897a248a3a37a102192715aa396
                }

            }
        }
        return count == numCourses;
    }

    private int[] buildInDegreeArray(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];

        for(int[] arr : prerequisites){
            int course = arr[0];
            inDegree[course]++;
        }
        return inDegree;
    }

    private HashMap<Integer, List<Integer>> buildMap (int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int courseX = arr[1];
            int courseThatDependsOnX = arr[0];

            List<Integer> list =  map.get(courseX);
            list.add(courseThatDependsOnX);
            map.put(courseX, list);
        }
        return map;
    }
}
