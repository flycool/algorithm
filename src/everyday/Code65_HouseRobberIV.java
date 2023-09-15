package everyday;

/**
 * 65 来自美团
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金
 * 现在有一位小偷计划从这些房屋中窃取现金
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷不会窃取相邻的房屋
 * 小偷的窃取能力定义为 他在窃取过程中能从单间房屋中窃取的最大金额 （不能偷大于小偷能力的房间）
 * 给你一个整数数组numS表示每间房屋存放的现金金额
 * 形式上，从左起第i间房屋中放有nums[i]美元
 * 另给你一个整数k,表示窃贼将会窃取的最少房屋数
 * 小偷一定要要窃取至少k间房屋，返回小偷的最小窃取能力
 * 测试链接：https://leetcode.cn/problems/house-robber-iv/
 *
 * 打家劫舍4
 */
public class Code65_HouseRobberIV {


    public int rob4(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        int m, ans = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (robber(nums, m) >= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    // nums 中大于 ability 的值不能要，且不能拿相邻的数，
    // 返回最多能拿几个数
    private int robber(int[] nums, int ability) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] <= ability ? 1 : 0;
        }
        if ((n == 2)) {
            return (nums[0] <= ability || nums[1] <= ability) ? 1 : 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0] <= ability ? 1 : 0;
        dp[1] = (nums[0] <= ability || nums[1] <= ability) ? 1 : 0;
        for (int i = 2; i < n; i++) {
            int p1 = dp[i - 1];
            int p2 = nums[i] <= ability ? 1 : 0;
            int p3 = dp[i - 2] + (nums[i] <= ability ? 1 : 0);
            dp[i] = Math.max(p1, Math.max(p2, p3));
        }
        return dp[n-1];
    }


    // 打家劫舍1
    // 不能选相邻数的最大累加和
    private int rob(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }
//        int[] dp = new int[n];
//        for (int i = 2; i < n; i++) {
//            int p1 = dp[i - 1];
//            int p2 = arr[i];
//            int p3 = dp[i - 2] + arr[i];
//            dp[i] = Math.max(p1, Math.max(p2, p3));
//        }

        //优化，可用有限变量更新
        int lastLast = arr[0];
        int last = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int p1 = last;
            int p2 = arr[i];
            int p3 = arr[i] + lastLast;
            int cur = Math.max(p1, Math.max(p2, p3));

            // 滚动更新
            lastLast = last;
            last = cur;
        }

        return last;
    }

}
