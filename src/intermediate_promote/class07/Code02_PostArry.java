package intermediate_promote.class07;

import java.util.HashMap;

public class Code02_PostArry {

    //一颗二叉树中没有重复的节点，且给定这棵树的先序和中序遍历，
    //求后序遍历数组
    public static int[] postArry(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        int n = pre.length;
        int[] pos = new int[n];
        HashMap<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inmap.put(in[i], i);
        }
        set(pre, in, pos, 0, n - 1, 0, n - 1, 0, n - 1, inmap);
        return pos;
    }

    private static void set(int[] pre, int[] in, int[] pos, int prei, int prej, int ini, int inj, int posi, int posj, HashMap<Integer, Integer> inmap) {
        if (prei < prej) {
            return;
        }
        if (prei == prej) {
            pos[posi] = pre[prei];
        }
        pos[posj] = pre[prei];
        int find = inmap.get(pos[posj]);//头结点在in[]什么位置，则它左侧就是左树，右侧就是右树

        //左右树递归
        set(pre, in, pos, prei + 1, prei + find - ini, ini, find - 1, posi, posi + find - ini - 1, inmap);
        set(pre, in, pos, prei + find - ini + 1, prej, find + 1, inj, posi + find - ini, posj - 1, inmap);
    }

}
