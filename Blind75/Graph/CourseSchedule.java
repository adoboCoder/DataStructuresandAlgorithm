package Blind75.Graph;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            map.get(prereq[1]).add(prereq[0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int i) {
        if (visited[i] == -1) {
            return false;
        }
        if (visited[i] == 1)
            return true;

        visited[i] = -1;

        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!dfs(map, visited, j)) {
                    return false;
                }
            }
        }
        visited[i] = 1;
        return true;
    }
}
