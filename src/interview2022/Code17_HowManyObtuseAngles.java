package interview2022;

import java.util.Arrays;
import java.util.List;

/**
 * 有一个以原点为圆心，半径为1的圆
 * 在这个圆的圆周上，有一些点
 * 因为所有的点都在圆周上，所以每个点可以有很简练的表达
 * 比如：用0来表示一个点，这个点就在（1，0）位置
 * 比如：用6000来表示一个点，这个点是（1，0）点沿着圆周逆时针转60.00度之后所在的位置
 * 比如：用18034来表示一个点，这个点是（1，0）点沿着圆周逆时针转180.34度之后所在的位置
 * 这样一来，所有的点都可以用 [0，36000) 范围上的数字表示
 * 那么任意三个点都可以组成一个三角形，返回能组成钝角三角形的数量
 */
public class Code17_HowManyObtuseAngles {

    public long obtuseAngles(int[] arr) {
        int n = arr.length;
        int m = n >> 1;
        int[] enlarge = new int[m];
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            enlarge[i] = arr[i];
            enlarge[i + n] = arr[i] + 36000;
        }
        long ans = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < m && (enlarge[r] - enlarge[l]) < 18000) {
                r++;
            }
            ans += num(r - l - 1);
        }
        return ans;
    }

    //排列组合
    private long num(long nodes) {
        return nodes < 2 ? 0 : ((nodes - 1) * nodes) >> 1;
    }

    //=================

    /**
     * 整个二位平面算是一张地图，给定 [x， y]，表示你站的x行y列
     * 你可以选择面朝的任何方向
     * 给定一个正数值angle，表示你视野的角度
     * 这个角度内你可以看无穷远，这个角度外你开不到任何东西
     * 给定一批点的二位坐标，返回你在朝向最好的情况下，最多能看到几个点
     */
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int n = points.size();
        int a = location.get(0);
        int b = location.get(1);
        int zero = 0;
        double[] arr = new double[n << 1];
        int m = 0;
        for (int i = 0; i < n; i++) {
            int x = points.get(i).get(0) - a;
            int y = points.get(i).get(1) - b;
            if (x == 0 && y == 0) {
                zero++;
            } else {
                arr[m] = Math.toDegrees(Math.atan2(y, x));
                arr[m + 1] = arr[m] + 360;
                m += 2;
            }
        }
        Arrays.sort(arr, 0, m);
        int max = 0;
        for (int L = 0, R = 0; L < n; L++) {
            while (R < m && (arr[R] - arr[L]) <= angle) {
                R++;
            }
            max = Math.max(max, R - L);
        }
        return max + zero;
    }
}
