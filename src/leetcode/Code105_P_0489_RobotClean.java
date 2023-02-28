package leetcode;

import java.util.HashSet;

/**
 * 105 leetcode 0489 扫地机器人
 * 有个空间，不知道边界，利用扫地机器人
 * 返回最经济的方式打扫空间
 */
public class Code105_P_0489_RobotClean {

    interface Robot {
        boolean move();

        void turnRight();

        void turnLeft();

        void clean();
    }

    private final int[][] ds = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }

    public void clean(Robot robot, int x, int y, int d, HashSet<String> visited) {
        robot.clean();
        visited.add(x + "_" + y);
        for (int i = 0; i < 4; i++) {
            int nd = (i + d) % 4;
            int nx = ds[nd][0] + x;
            int ny = ds[nd][1] + y;
            if (!visited.contains(nx + "_" + ny) && robot.move()) {
                clean(robot, nx, ny, nd, visited);
            }
            robot.turnRight();
        }
        //回到之前的位置
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
