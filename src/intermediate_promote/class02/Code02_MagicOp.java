package intermediate_promote.class02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code02_MagicOp {

    /**
     * 有一个n个整数的集合a，和有一个m个整数的集合b
     * 定义magic操作：从一个集合中取一个元素，放到另一个集合中，且操作后每个集合的平均值都大于操作前
     * 求最多能进行多少次magic操作？
     */
    public static int magicOps(int[] a, int[] b) {
        double sum1 = 0;
        for (int i = 0; i < a.length; i++) {
            sum1 += a[i];
        }
        double sum2 = 0;
        for (int i = 0; i < b.length; i++) {
            sum2 += b[i];
        }
        if (avg(sum1, a.length) == avg(sum2, b.length)) {
            return 0;
        }

        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, a.length) > avg(sum2, b.length)) {
            arrMore = a;
            arrLess = b;
            sumMore = sum1;
            sumLess = sum2;
        } else {
            arrMore = b;
            arrLess = a;
            sumMore = sum2;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int less : arrLess) {
            setLess.add(less);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            int cur = arrMore[i];
            if (cur > avg(sumLess, lessSize)
                    && cur < avg(sumMore, moreSize)
                    && !setLess.contains(cur)) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(cur);
                ops++;
            }
        }
        return ops;
    }

    private static double avg(double av, int size) {
        return av / size;
    }
}
