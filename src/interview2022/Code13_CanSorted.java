package interview2022;

/**
 * 给定两个数组A和B，长度都是N
 * A[i] 不可以在A中和其他数交换，只可以选择和B[i]交换（0<=i<n）
 * 你的目的是让A有序，返回你能不能做到
 */
public class Code13_CanSorted {

    public boolean canSorted(int[] a, int[] b) {
        return process(a, b, 0, Integer.MIN_VALUE);
    }

    public boolean process(int[] a, int[] b, int index, int pre) {
        if (index == a.length) {
            return true;
        }
        boolean p1 = pre <= a[index] && (process(a, b, index + 1, a[index]));
        boolean p2 = pre <= b[index] && (process(a, b, index + 1, b[index]));
        return p1 | p2;
    }

    public boolean process2(int[] a, int[] b, int index, boolean isSwap) {
        if (index == a.length) {
            return true;
        }
        int pre = isSwap ? b[index - 1] : a[index - 1];
        boolean p1 = pre <= a[index] && (process2(a, b, index + 1, false));
        boolean p2 = pre <= b[index] && (process2(a, b, index + 1, true));
        return p1 | p2;
    }
}
