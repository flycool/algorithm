package everyday;

/**
 * 57 来自腾讯音乐
 * 给定一棵树，一共有n个点
 * 每个点上没有值，请把1~n这些数字，不重复的分配到二叉树上
 * 做到：奇数层节点的值总和与偶数层节点的值总和相差不超过1
 * 返回奇数层节点分配值的一个方案
 * 2<=n<=10^5
 */
public class Code57_OddLevelEvenLevelSumClosed {

    //一共n个节点，奇数层的节点是k个
    public int[] team(int n, int k) {
        int sum = (1 + n) * n / 2;
        int p1 = sum / 2;
        int p2 = (sum+1) / 2;
        int[] ans = generate(p1, n, k);
        if (ans == null && (sum & 1) == 1 /** or (p1 != p2) **/) {
            ans = generate(p2, n, k);
        }
        return ans != null ? ans : new int[]{-1};
    }

    //n个数字，从中选k个，累加和正好x，返回哪k个数
    public int[] generate(int x, int n, int k) {
        int minSumK = (1 + k) * k / 2;
        int range = n - k;
        if (x < minSumK || x > minSumK + k * range) {
            return null;
        }
        int add = x - minSumK;
        int rightSize = add / range;
        int minIndex = (k - rightSize) + add % range;
        int leftSize = (k - rightSize) - (add % range == 0 ? 0 : 1);
        int[] ans = new int[k];
        for (int i = 0; i < leftSize; i++) {
            ans[i] = i + 1;
        }
        if (add % range != 0) {
            ans[leftSize] = minIndex;
        }
        for (int i = k - 1, j = 0; j < rightSize; i--, j++) {
            ans[i] = n - j;
        }
        return ans;
    }
}
