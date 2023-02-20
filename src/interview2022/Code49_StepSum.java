package interview2022;

/**
 * 定义何为step sum？
 * 比如680，680+68+6 = 754，680的step sum叫754
 * 给定一个正数num，判断它是不是某个数的step sum
 * (二分法)
 */
public class Code49_StepSum {

    public boolean isStepSum(int num) {
        int l = 0, r = num;
        int m;
        int cur;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            cur = stepSum(m);
            if (cur == num) {
                return true;
            } else if (cur < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public int stepSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num;
            num /= 10;
        }
        return sum;
    }
}
