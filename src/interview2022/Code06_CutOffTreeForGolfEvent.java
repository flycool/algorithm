package interview2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个m x n 的矩阵表示， 在这个矩阵中：
 * <p>
 * 0 表示障碍，无法触碰
 * 1表示地面，可以行走
 * 比 1 大的数表示有树的单元格，可以行走，数值表示树的高度
 * 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
 * <p>
 * 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * <p>
 * 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * <p>
 * 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cut-off-trees-for-golf-event
 */
public class Code06_CutOffTreeForGolfEvent {

    public static int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        ArrayList<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = forest.get(i).get(j);
                if (val > 1) {
                    cells.add(new int[]{i, j, val});
                }
            }
        }
        cells.sort((a, b) -> a[2] - b[2]);
        int ans = 0, lastRow = 0, lastColumn = 0;
        for (int[] cell : cells) {
            int step = bestWalk(forest, lastRow, lastColumn, cell[0], cell[1]);
            if (step == -1) {
                return -1;
            }
            ans += step;
            lastRow = cell[0];
            lastColumn = cell[1];
            forest.get(lastRow).set(lastColumn, 1);
        }
        return ans;
    }

    public static int[] next = {-1, 0, 1, 0, -1};//4个方向

    private static int bestWalk(List<List<Integer>> forest, int startRow, int startColumn, int targetRow, int targetColumn) {
        int n = forest.size();
        int m = forest.get(0).size();
        boolean[][] seen = new boolean[n][m];
        LinkedList<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, startRow, startColumn});//步数， 坐标
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int step = cur[0], row = cur[1], column = cur[2];
            if (row == startRow && column == targetColumn) {
                return step;
            }
            seen[row][column] = true;
            for (int i = 1; i < 5; i++) {
                int nextRow = row + next[i - 1];
                int nextColumn = row + next[i];
                if (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < n && !seen[nextRow][nextColumn]
                        && forest.get(nextRow).get(nextColumn) > 0) {
                    int[] move = {step + 1, nextRow, nextColumn};
                    if ((i == 1 && nextRow > targetRow) //up
                            || (i == 2 && nextColumn < targetColumn)
                            || (i == 3 && nextRow < targetRow)
                            || (i == 4 && nextColumn > targetColumn)
                    ) {
                        deque.addFirst(move); //更近的话
                    } else {
                        deque.addLast(move); //更远
                    }
                }
            }
        }
        return -1;
    }
}
















