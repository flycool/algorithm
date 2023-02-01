package base.class09_Recursive;

public class Code08_nqueen {

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    //要求不同行，不同列，不同斜线
    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        //在i行上，每列尝试
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        //在0..i-1 行进行判断
        for (int k = 0; k < i; k++) {
            //共列，和 共斜线
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    //=============

    //不能超过32皇后问题
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;//n=8, 那么，0~7位都是1，高位为0
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = 0;//可以放皇后的信息
        int mostRightOne = 0;//最右的一个有效值
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {//不断取最右的1(有效值)
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne,
                    (colLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n1 = num1(8);
        int n2 = num2(8);
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
    }
}
