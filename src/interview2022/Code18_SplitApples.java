package interview2022;

/**
 * 有m个同样的苹果，认为苹果之间无差别
 * 有n个同样的盘子，认为盘子之间无差别
 * 还有，比如5个苹果如果放进3个盘子，
 * 那么1，3，1和1，1，3和3，1，1的放置方法，也认为是一种方法
 * 如上的设定下，返回有多少种放置方法
 */
public class Code18_SplitApples {

    public int splitApples1(int apples, int plates) {
        return process1(1, apples, plates);
    }

    public int process1(int pre, int remainApples, int remainPlates) {
        if (remainApples == 0) {
            return 1;
        }
        if (remainPlates == 0) {
            return 0;
        }
        if (pre > remainApples) {
            return 0;
        }
        int way = 0;
        for (int cur = pre; cur <= remainApples; cur++) {
            way += process1(cur, remainApples - cur, remainPlates - 1);
        }
        return way;
    }

    //==========
    public int splitApples2(int apples, int plates) {
        if (apples == 0) {
            return 1;
        }
        if (plates == 0) {
            return 0;
        }
        if (plates > apples) {
            return splitApples2(apples, apples);
        } else {
            //不全用盘子 + 全用盘子
            return splitApples2(apples, plates - 1) + splitApples2(apples - plates, plates);
        }
    }
}
