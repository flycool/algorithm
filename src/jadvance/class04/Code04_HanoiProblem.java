package jadvance.class04;

public class Code04_HanoiProblem {

    public static int step1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return process(arr, arr.length - 1, 1, 2, 3);
    }

    //把arr[0..i]的圆盘，从from全部移动到to
    //返回，根据arr中的状态arr[0..i]，它是最优解的第几步
    //N层汉若塔问题要走 2^n-1 次步数 O(N)
    private static int process(int[] arr, int i, int from, int other, int to) {
        if (i == -1) {//没有圆盘
            return 0;
        }
        if (arr[i] == other) {
            return -1;
        }
        if (arr[i] == from) {
            return process(arr, i - 1, from, to, other);
        } else {
            int rest = process(arr, i - 1, other, from, to);
            if (rest == -1) {
                return -1;
            }
            return (1 << i) + rest;
        }
    }

    //迭代方式
    private static int step2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int from = 1;
        int other = 2;
        int to = 3;
        int i = arr.length - 1;
        int tmp;
        int res = 0;
        while (i >= 0) {
            if (arr[i] == other) {
                return -1;
            }
            if (arr[i] == from) {
                tmp = to;
                to = other;
            } else {
                res += 1 << i;
                tmp = from;
                from = other;
            }
            other = tmp;
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 1};
        int i = step1(arr);
        int i1 = step2(arr);
        System.out.println(i);
        System.out.println(i1);
    }
}
