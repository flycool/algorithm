package everyday;

/**
 * 28 字节
 * 给定正数N,表示用户数量,用户编号从0~N-1
 * 给定正数M,表示实验数量,实验编号从0~M-1
 * 给定长度为N的二维数组A
 * A[i]={a,b,c}表示,用户i报名参加了a号、b号、c号实验
 * 给定正数Q,表示查询的条数
 * 给定长度为Q的二维数组B,
 * B[i]={e,f}表示,第i条查询想知道e号、f号实验,一共有多少人(去重统计)
 * 返回每一条查询的结果数组
 * 数据描述:
 * 1<=N<=10^5
 * 1<=M<=10^2
 * 所有查询所列出的所有实验编号数量 <=10^4
 * （位图）
 */
public class Code28_everyQueryUser {

    public int[] record(int n, int m, int q, int[][] a, int[][] b) {
        // 每个实验需要几个整数
        int parts = (n + 31) / 32; // 向上取整
        int[][] bitmap = new int[m][parts];
        for (int i = 0; i < n; i++) {
            for (int exp : a[i]) {//每个人参加的实验
                //每个实验在第i个整数的第几位，标记为1
                bitmap[exp][i / 32] |= 1 << (i % 32);
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int all = 0;
            for (int j = 0; j < parts; j++) {
                int status = 0;
                for (int exp : b[i]) {
                    status |= bitmap[exp][j];//把所有参加exp实验的人求或，可去重
                }
                all += countOnes(status);
            }
            ans[i] = all;
        }
        return ans;
    }

    private static int countOnes2(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }

    private static int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = countOnes(7);
        System.out.println(i);
    }
}
