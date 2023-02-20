package interview2022;

/**
 * 50.跳跃游戏
 * arr[] 数组里的数字是你可以选择跳的步数（不超过数字），
 * 跳到n-1最少的次数
 */
public class Code50_JumpGame {

    public int jumpGame(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int step = 0, cur = 0, next = 0;
        for (int i = 0; i < n; i++) {
            if (cur < i) {
                step++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);//下一步的最大距离
        }
        return step;
    }
}
