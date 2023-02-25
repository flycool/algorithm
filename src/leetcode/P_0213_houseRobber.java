package leetcode;

//81 leetcode 0213 打家劫舍2
public class P_0213_houseRobber {

    // 可能性 0~n-2 , 1~n-1 取max
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // n~n-2
        int pre2 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            int tmp = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = tmp;
        }
        int ans1 = pre1;


        pre2 = nums[1];
        pre1 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int tmp = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = tmp;
        }
        int ans2 = pre1;
        return Math.max(ans1, ans2);
    }

    //打家劫舍1
    public int houseRobber1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int p1 = arr[i];
            int p2 = dp[i - 1];
            int p3 = arr[i] + dp[i - 2];
            dp[i] = Math.max(Math.max(p1, p2), p3);
        }
        return dp[n - 1];
    }
}
