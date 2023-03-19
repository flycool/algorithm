package everyday;

/**
 * 24 网易
 * 给定一个正数数组a,表示每个小朋友的得分
 * 任何两个相邻的小朋友,如果得分一样,怎么分糖果无所谓,
 * 但如果得分不一样,分数大的一定要比分数少的多拿一些糖果
 * 假设所有的小朋友坐成一个环形,
 * 返回在不破坏上一条规则的情况下,需要的最少糖果数
 * （找到洼地，分一块糖，求左右坡）
 * （组成洼地为头尾的数组）
 */
public class Code24_circleCandy {

    public int minCandy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int n = arr.length;
        int minIndex = 0;//找到局部的最小值
        for (int i = 0; i < n; i++) {
            if (arr[i] <= arr[lastIndex(i, n)] && arr[i] <= arr[nextIndex(i, n)]) {
                minIndex = i;
                break;
            }
        }
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++, minIndex = nextIndex(minIndex, n)) {
            nums[i] = arr[minIndex];
        }
        int[] left = new int[n + 1];
        left[0] = 1;
        for (int i = 1; i <= n; i++) {
            left[i] = nums[i] > nums[i - 1] ? (left[i - 1] + 1) : 1;
        }
        int[] right = new int[n + 1];
        right[0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = nums[i] > nums[i + 1] ? (right[i + 1] + 1) : 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    public int nextIndex(int i, int n) {
        return i == n - 1 ? 0 : (i + 1);
    }

    public int lastIndex(int i, int n) {
        return i == 0 ? n - 1 : i - 1;
    }
}
