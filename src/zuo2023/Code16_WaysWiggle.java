package zuo2023;

/**
 * 一个数组如果满足：
 * 升降升降升降...或者 降升降升...都是满足的
 * 给定一个数组，
 * 1,看有几种方法能够剔除一个元素，达成上述的要求
 * 2,数组天然符合要求返回0
 * 3,剔除1个元素达成不了要求，返回-1，
 * 比如：
 * 给定[3,4,5,3,7]，返回3
 * 移除0元素，4537符合
 * 移除1元素，3537符合
 * 移除2元素，3437符合
 * 再比如：给定[1,2,3,4]返回-1
 * 因为达成不了要求
 */
public class Code16_WaysWiggle {

    public int ways(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length;
        boolean[] rightUp = new boolean[n];
        boolean[] rightDown = new boolean[n];
        rightUp[n - 1] = true;
        rightDown[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            rightUp[i] = arr[i] < arr[i + 1] && rightDown[i + 1];
            rightDown[i] = arr[i] > arr[i + 1] && rightUp[i + 1];
        }
        //天然成立
        if (rightUp[0] || rightDown[0]) {
            return 0;
        }
        int ans = (rightUp[1] || rightDown[1]) ? 1 : 0;
        //两个滚动变量
        boolean leftUp = true;
        boolean leftDown = true;
        boolean tmp;
        for (int i = 1, l = 0, r = 2; i < n - 1; i++, l++, r++) {
            ans += (arr[l] > arr[r] && rightUp[r] && leftDown) ||
                    (arr[l] < arr[r] && rightDown[r] && leftUp) ? 1 : 0;
            tmp = leftUp;
            leftUp = arr[l] > arr[r] && leftDown;
            leftDown = arr[l] < arr[r] && tmp;
        }
        // 单独算一下 n-1 的位置的数
        ans += leftUp || leftDown ? 1 : 0;
        return ans == 0 ? -1 : ans;

    }


}
