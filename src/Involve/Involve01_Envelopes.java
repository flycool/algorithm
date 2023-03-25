package Involve;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1. 腾讯
 * WG的秘书有一堆的文件袋,现在秘书需要把文件袋嵌套收纳起来
 * 请你帮他计算下,最大嵌套数量。
 * 给你一个二维整数数组folders ,其中folders[i]=[wi,hi],表示第i个文件袋的宽度和长度
 * 当某一个文件袋的宽度和长度都比这个另外一个文件袋大的时候
 * 前者就能把后者装起来,称之为一组文件袋。
 * 请计算,最大的一组文件袋的数量是多少。
 * 输入: [ [6,10],[11,14],[6,1],[16,14],[13,2] ]
 * 输出:3
 * （最长递增子序列）
 * ends[i] = x
 * 表示所有长度为i+1的递增子序列中，最小结尾为x
 * <p>
 * 排序：长度： 小--》大，高度：大--》小
 * 去除高度作为一个数组，求此数组的最长递增子序列，就是最大的一组文件袋的数量是多少
 */
public class Involve01_Envelopes {

    public int maxEnvelopes(int[][] matrix) {
        Envelope[] arr = sort(matrix);
        int[] ends = new int[arr.length];
        ends[0] = arr[0].h;
        int right = 0;
        int l, r, m;
        for (int i = 0; i < arr.length; i++) {
            l = 0;
            r = right;
            // 二分，找到大于ends[m]最左的数
            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i].h) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i].h;
        }
        return right + 1;// 答案即为 end数组的长度
    }

    class Envelope {
        public int w;
        public int h;

        public Envelope(int weight, int height) {
            this.w = weight;
            this.h = height;
        }
    }

    class EnvelopeComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.w != o2.w ? o1.w - o2.w : o2.h - o1.h;
        }
    }

    public Envelope[] sort(int[][] matrix) {
        Envelope[] envelopes = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            envelopes[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(envelopes, new EnvelopeComparator());
        return envelopes;
    }

}
