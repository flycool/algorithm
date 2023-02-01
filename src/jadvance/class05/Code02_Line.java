package jadvance.class05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Code02_Line {

    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class LineComparator implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    /**
     * 平面内有n个矩形，第i个矩形的左下角坐标为(x1[i],y1[i])，右上角坐标为(x2[i],y2[i])。
     * 如果两个或者多个矩形有公共区域则认为他们是相互重叠的（不考虑边界和角落）。
     * 请你计算出平面内重叠矩形的数量最多的地方，有多少个矩形相互重叠。
     * 可以把二维的变成一维的解决
     */
    //原型：多少段线段重合
    public static int maxLine(Line[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        Arrays.sort(arr, new LineComparator());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0].end);
        int res = 1;
        for (Line line : arr) {
            while (set.first() <= line.start) {
                set.pollFirst();
            }
            set.add(line.end);
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Line[] lineArry = {new Line(2, 5), new Line(1, 9), new Line(3, 10), new Line(6, 8), new Line(2, 4),};
        int i = maxLine(lineArry);
        System.out.println(i);
    }
}
