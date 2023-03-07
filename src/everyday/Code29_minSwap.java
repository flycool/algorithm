package everyday;

import java.util.HashMap;

/**
 * 29 美团
 * 两种颜色的球，蓝色和红色，都按1~n编号，共计2n个
 * 为方便放在一个数组中，红球编号取负，篮球不变，并打乱顺序,
 * 要求同一种颜色的球按编号升序排列，可以进行如下操作:
 * 交换相邻两个球，求最少操作次数。
 * [3,-3,1,-4,2,-2,-1,4]
 * 最终交换结果为
 * [1,2,3,-1,-2,-3,-4,4]
 * 最少交换次数为10
 * n<=1000
 * （index tree）
 */
public class Code29_minSwap {

    public int minSwap(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int lastA = 0, lastB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                lastA = Math.max(lastA, arr[i]);
            } else {
                lastB = Math.max(lastB, Math.abs(arr[i]));
            }
            map.put(arr[i], i);
        }
        IndexTree it = new IndexTree(n);
        for (int i = 0; i < n; i++) {
            it.add(i, 1);
        }
        return f(lastA, lastB, it, n - 1, map);
    }

    private int f(int lastA, int lastB, IndexTree it, int end, HashMap<Integer, Integer> map) {
        if (lastA == 0 && lastB == 0) {
            return 0;
        }
        int p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
        int index, cost, next;
        if (lastA != 0) {
            index = map.get(lastA);
            cost = it.sum(index, end) - 1;
            it.add(index, -1);
            next = f(lastA - 1, lastB, it, end, map);
            it.add(index, 1);//恢复现场，把index位置变成0
            p1 = cost + next;
        }
        if (lastB != 0) {
            index = map.get(-lastB);
            cost = it.sum(index, end) - 1;
            it.add(index, -1);
            next = f(lastA, lastB - 1, it, end, map);
            it.add(index, 1);//恢复现场，把index位置变成0
            p2 = cost + next;
        }
        return Math.min(p1, p2);
    }


    public class IndexTree {
        public int n;
        public int[] map;

        public IndexTree(int n) {
            this.n = n;
            map = new int[n];
        }

        public void add(int i, int value) {
            map[i] = value;
        }

        public int sum(int i, int end) {
            int sum = 0;
            for (int j = i; j < end; j++) {
                sum += map[j];
            }
            return sum;
        }
    }
}
