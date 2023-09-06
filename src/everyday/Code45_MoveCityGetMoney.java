package everyday;

import java.util.Arrays;

/**
 * 45. 美团
 * 有n个城市，城市从0到n-1进行编号。小美最初住在k号城市中
 * 在接下来的m天里，小美每天会收到一个任务
 * 她可以选择完成当天的任务或者放弃该任务
 * 第i天的任务需要在ci号城市完成，如果她选择完成这个任务
 * 若任务开始前她恰好在ci号城市，则会获得ai的收益
 * 若她不在ci号城市，她会前往ci号城市，获得bi的收益
 * 当天的任务她都会当天完成
 * 任务完成后，她会留在该任务所在的号城市直到接受下一个任务
 * 如果她选择放弃任务，她会停留原地，且不会获得收益
 * 小美想知道，如果她合理地完成任务，最大能获得多少收益
 * 输入描述：
 * 第一行三个正整数n,m和k,表示城市数量，总天数，初始所在城市
 * 第二行为m个整数c1,c2,.....cm,其中ci表示第i天的任务所在地点为ci
 * 第三行为m个整数a1,a2,.....am,其中ai表示完成第i天任务且地点不变的收益
 * 第四行为m个整数b1,b2,.....bm,其中bi表示完成第i天的任务且地点改变的收益
 * 0<=k,ci<=n<=3000
 * 1<= m <=30000
 * 0<= ai,bi <=10^9
 */
public class Code45_MoveCityGetMoney {

    private int maxPorfit(int n, int m, int k, int[] c, int[] a, int[] b) {
        SegmentTree45 st = new SegmentTree45(n);
        st.update(k, 0);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int p1 = Math.max(st.max(0, c[i] - 1), st.max(c[i] + 1, n - 1)) + b[i];
            int p2 = st.max(c[i], c[i]) + a[i];
            int curAns = Math.max(p1, p2);
            ans = Math.max(ans, curAns);
            st.update(c[i], curAns);
        }
        return ans;
    }

    private static class SegmentTree45 {
        private int n;
        private int[] max;

        public SegmentTree45(int n) {
            this.n = n;
            max = new int[(n + 1) << 2];
            Arrays.fill(max, Integer.MIN_VALUE);
        }

        public void update(int index, int value) {

        }

        public int max(int l, int r) {
            return 0;
        }
    }
}

























