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
        }
        int count = 0;
        while(!queue.isEmpty()){
            int currentCourse  = queue.poll();
            count++;
            for(int neighbor : map.get(currentCourse)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
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
