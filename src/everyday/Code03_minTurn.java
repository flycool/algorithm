package everyday;

/**
 * 3. bilibili
 * 现在有n条鱼，每条鱼的体积为Ai，从左到右排列，数组arr给出
 * 每一轮，左边的大鱼一定会吃掉右边比自己小的第一条鱼
 * 并且每条鱼吃比自己小的鱼的事件是同时发生的
 * 返回多少轮之后，鱼的数量会稳定
 * 注意：6 6 3 3
 * 第一轮过后：
 * 对于两个6来说，右边比自己小的第一条鱼都是第1个3，所以只有这个3被吃掉，数组变成： 6 6 3（第2个3）
 * 第二轮过后：6 6
 * 返回 2
 * （单调栈）
 */
public class Code03_minTurn {

    public int minTurn(int[] arr) {
        int n = arr.length;
        int[][] stack = new int[n][2];//2位代表，(arr[i],当前轮次)
        int size = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curAns = 0;
            while (size > 0 && stack[size - 1][0] < arr[i]) {
                curAns = Math.max(curAns + 1, stack[--size][1]);
            }
            stack[size][0] = arr[i];
            stack[size++][1] = curAns;
            ans = Math.max(ans, curAns);
        }
        return ans;
    }
}
