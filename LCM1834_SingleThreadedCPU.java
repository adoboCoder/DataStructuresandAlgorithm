import java.util.*;

class LCM1834_SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int[][] allTasks = new int[tasks.length][3];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2] == 0 ? a[0] - b[0] : a[2] - b[2]);
        for (int i = 0; i < tasks.length; i++) {
            allTasks[i][0] = i; // index
            allTasks[i][1] = tasks[i][0]; //enqueTime
            allTasks[i][2] = tasks[i][1]; //ProcessingTime
        }

        Arrays.sort(allTasks, (a, b) -> a[1] - b[1]);
        int i = 0;
        int index = 0; // index for result
        int currentTime = 0;

        int[] result = new int[tasks.length];

        while (i < tasks.length) {
            // check if i th tasks starting time is smaller or equal to currenttime
            while (i < tasks.length && allTasks[i][1] <= currentTime) {
                minHeap.add(allTasks[i]);
                i++;
            }
            if (minHeap.isEmpty()) {
                currentTime = allTasks[i][1];
            }
            if (!minHeap.isEmpty()) {
                int[] curTask = minHeap.poll();
                result[index] = curTask[0];
                currentTime += curTask[2];
                index++;
            }
        }
        while (!minHeap.isEmpty()) {
            int[] curTask = minHeap.poll();
            result[index] = curTask[0];
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
        System.out.println(Arrays.toString(LCM1834_SingleThreadedCPU.getOrder(tasks)));
        int[][] tasks2 = { {7,10}, {7, 12} ,{7, 5}, {7, 4}, {7, 2} };
        System.out.println(Arrays.toString(LCM1834_SingleThreadedCPU.getOrder(tasks2)));
    }
}