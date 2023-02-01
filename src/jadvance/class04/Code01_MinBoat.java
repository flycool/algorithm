package jadvance.class04;

public class Code01_MinBoat {
    /**
     * 给定一个数组arr，长度为N且每个值都是正数，代表N个人的体重。
     * 再给定一个正数limit，代表一艘船的载重。
     * 以下坐船规则：
     * 1）每艘船最多只能坐两人；
     * 2）乘客的体重和不能超过limit。
     * 返回如果同时让这N个人过河最少需要几条船？
     */
    //保证arr有序
    public static int minBoat(int[] arr, int limit) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        if (arr[len - 1] <= limit / 2) {
            return (len + 1) / 2; //向上取整
        }
        if (arr[0] > limit / 2) {
            return len;
        }
        int lessR = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] >= limit / 2) {//获取>=limit/2 的最右的值
                lessR = i;
                break;
            }
        }
        int L = lessR;
        int R = lessR + 1;
        int lessUnUsed = 0;//统计没有匹配到的值
        while (L >= 0) {
            int solved = 0;
            while (R < len && arr[L] + arr[R] <= limit / 2) {
                R++;
                solved++;
            }
            if (solved == 0) {
                lessUnUsed++;
                L--;
            } else {
                L = Math.max(-1, L - solved);
            }
        }
        int lessAll = lessR + 1;//左半区的总数
        int lessUsed = lessAll - lessUnUsed;//左半区已匹配的数量
        int moreUnSolved = len - lessR - 1 - lessUsed;//右半区没匹配的数量
        return lessUsed + (lessUnUsed + 1) >> 1 + moreUnSolved;
    }
}
