import java.util.*;

class LCH_489RobotRoomCleaner {
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public  void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }
    private void clean(Robot robot, int x, int y, int currentDicrection, Set<String> visited){
        robot.clean();
        visited.add(x + "," + y);
        for(int nDirection = currentDicrection; nDirection < currentDicrection + 4; nDirection++){
            int nx = directions[nDirection % 4][0] + x;
            int ny = directions[nDirection % 4][1] + y;
            if(!visited.contains(nx + "," + ny) && robot.move()){
                clean(robot, nx, ny, nDirection % 4, visited);
            }
            robot.turnRight();
        }
        // Moves backward one step while maintaining the orientation.
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

/*


    0
3  -|-  1
    2


TC: O(n - m) , n number of cells in the room, m number of obstacles
SC: O(n - m) , n number of cells in the room, m number of obstacles


    */