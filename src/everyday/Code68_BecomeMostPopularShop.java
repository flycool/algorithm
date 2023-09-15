package everyday;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 68 来自华为OD
 * 1号店铺贿赂问题
 * 店铺数量n,编号1~n
 * 人的数量m,编号1~m
 * 每个人有自己投票的店铺p,和改投1号店的报价x
 * 返回想让1号店铺成为人气最高的店，至少花多少钱
 * 1<=p,n,m<=3000
 * 1<=X<=10^9
 * <p>
 * arr: [3, 100].. // 支持3号店铺， 转投1号店铺需要100金钱
 */
public class Code68_BecomeMostPopularShop {

    public long minCost(int n, int m, int[][] arr) {
        int[] cnt = new int[n + 1];
        //统计每个店铺支持的人数
        for (int[] p : arr) {
            cnt[p[0]]++;
        }
        boolean needChange = false;
        for (int i = 2; i <= n; i++) {
            if (cnt[i] > cnt[1]) {
                needChange = true;
                break;
            }
        }
        // 1号店铺人气已经最高，直接返回0
        if (!needChange) {
            return 0;
        }

        // 数组根据金钱数量从小到大排序
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        // 每个店铺对应的支持者的列表
        ArrayList<ArrayList<Integer>> shops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            shops.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            // arr[i][0] : 表示第 i 个人所在的店铺
            shops.get(arr[i][0]).add(i);
        }

        boolean[] used = new boolean[m];
        long ans = Integer.MAX_VALUE;
        // 从当前1号店的人数开始遍历
        for (int i = cnt[1] + 1; i <= m; i++) {
            long money = f(arr, n, cnt[1], i, shops, used);
            if (money != -1) {
                ans = Math.min(ans, money);
            }
        }
        return ans;
    }

    /**
     * @param n       店铺
     * @param already 1号店已经有的人数
     * @param target  1 号店要到达能成为人气王的人数
     * @param shops   每个店铺的支持者
     * @param used    某个人是否改投1号店
     */
    private long f(int[][] arr, int n, int already, int target, ArrayList<ArrayList<Integer>> shops, boolean[] used) {
        Arrays.fill(used, false);
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            //看看哪个店的支持者人数超过target
            // needCount: 当前店铺需要多少人转投
            int needCount = Math.max(0, shops.get(i).size() - target + 1);
            for (int j = 0; j < needCount; j++) {
                //需改投的人
                int people = shops.get(i).get(j);
                sum += arr[people][1];
                used[people] = true;
            }
            already += needCount;
            if (already > target) {// 需要target成为人气王的条件失败，返回-1
                return -1;
            }
        }
        // 人数还是不够target，补齐人数
        for (int i = 0, j = 0; already + j <= target; i++) {
            if (arr[i][0] != 1 && !used[i]) {
                sum += arr[i][1];
                j++;
            }
        }
        return sum;
    }
}

