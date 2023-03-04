package everyday;

/**
 * 22 京东第三道
 * 这里有n个航班，它们分别从1到n进行编号。
 * 有一份航班预订表 bookings
 * 表中第 i 条预订记录bookings[i]=[a,b,c]
 * 意味着在从 a 到 b 的每个航班上预订了c个座位。
 * 请你返回一个长度为n的数组answer ,
 * 里面的元素是每个航班预定的座位总数。
 * 测试链接:
 * https://leetcode.cn/problems/corporate-flight-bookings/
 * （参分数组，依次加工前缀和）
 */
public class Code22_corpFlightBooking {

    public int[] corpFlightBooking(int[][] bookings, int n) {
        // 差分数组  0 1 2 3..n n+1
        int[] cnt = new int[n + 2];
        for (int[] booking : bookings) {
            cnt[booking[0]] += booking[2];
            cnt[booking[1] + 1] -= booking[2];
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];//前缀和
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = cnt[i + 1];
        }
        return ans;
    }
}
