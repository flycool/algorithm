package leetcode;

/**
 * 103 leetcode 0499 迷宫iii
 * （宽度优先遍历）
 * （x, y, 方向）
 */
public class Code103_P_0499_TheMazeIII {

    /**
     * (r,c):来到了哪个位置
     * d:从哪个方向来的
     * p:之前做了什么决定让你来到这个位置
     */
    public class Node {
        public int c;
        public int r;
        public int d;
        public String p;

        public Node(int c, int r, int d, String p) {
            this.c = c;
            this.r = r;
            this.d = d;
            this.p = p;
        }
    }




}
