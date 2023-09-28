package struct.segmenttree;

//线段树
public class SegmentTree {

    private final int[] arr;
    private final int[] sum;

    //以下三个数组，存储任务(add， update)的信息
    private final int[] lazy;
    private final int[] change;
    private final boolean[] update;

    public SegmentTree(int[] origin) {
        int maxn = origin.length + 1;
        arr = new int[maxn];//arr[0]不用
        for (int i = 1; i < maxn; i++) {
            arr[i] = origin[i - 1];
        }
        sum = new int[maxn << 2]; // maxn*4 的容量
        lazy = new int[maxn << 2];
        change = new int[maxn << 2];
        update = new boolean[maxn << 2];
    }

    public void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, rt << 1);// rt*2 左孩子
        build(mid + 1, r, rt << 1 | 1);// rt*2+1 右孩子
        pushUp(rt);// root
    }

    // L..R -> 任务范围， 所有值累加 C
    // l, r -> 表达的范围
    // rt -> 去哪找l，r范围上的信息
    public void add(
            int L, int R, int C,
            int l, int r,
            int rt
    ) {
        // 任务的范围彻底覆盖了当前的表达范围
        if (L <= l && r <= R) {
            sum[rt] += C * (r - l + 1);
            lazy[rt] += C;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);

        if (L <= mid) {
            add(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        //左右孩子做完，更新sum信息
        pushUp(rt);
    }

    public void update(int L, int R, int C, int l, int r, int rt) {
        if (L <= r && r <= R) {
            update[rt] = true;
            change[rt] = C;
            sum[rt] = C * (r - l + 1);
            lazy[rt] = 0;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);

        if (L <= mid) {
            update(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    public long query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, r, rt << 1 | 1);
        }
        return ans;
    }

    private void pushUp(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    // 下发所有之前积累下来的任务
    // ln:左孩子数量
    // rn:右孩子数量
    private void pushDown(int rt, int ln, int rn) {
        if (update[rt]) {
            update[rt << 1] = true;
            update[rt << 1 | 1] = true;
            change[rt << 1] = change[rt];
            change[rt << 1 | 1] = change[rt];

            lazy[rt << 1] = 0;
            lazy[rt << 1 | 1] = 0;
            sum[rt << 1] = change[rt] * ln;
            sum[rt << 1 | 1] = change[rt] * rn;
            update[rt] = false;
        }
        if (lazy[rt] != 0) {
            lazy[rt << 1] += lazy[rt];
            sum[rt << 1] += lazy[rt] * ln;

            lazy[rt << 1 | 1] += lazy[rt];
            sum[rt << 1 | 1] += lazy[rt] * rn;

            lazy[rt] = 0;
        }
    }
}
