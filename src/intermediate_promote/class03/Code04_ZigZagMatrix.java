package intermediate_promote.class03;

public class Code04_ZigZagMatrix {

    //用zigzag(之字形的)的方式打印矩阵
    public static void zigZagMatrixPrint(int[][] m) {
        int ar = 0, ac = 0;
        int br = 0, bc = 0;
        int endr = m.length - 1;
        int endc = m[0].length - 1;
        boolean fromUp = false;
        while (ar != endr + 1) {
            zigZagPrint(m, ar, ac, br, bc, fromUp);
            ar = ac == endc ? ar + 1 : ar;
            ac = ac == endc ? ac : ac + 1;
            bc = br == endr ? bc + 1 : bc;
            br = br == endr ? br : br + 1;
            fromUp = !fromUp;
        }
    }

    //斜线打印
    private static void zigZagPrint(int[][] m, int ar, int ac, int br, int bc, boolean f) {
        if (f) {//右向下打印
            while (ar != br + 1) {
                System.out.print(m[ar++][ac--] + " ");
            }
        } else {//下向上打印
            while (br != ar - 1) {
                System.out.print(m[br--][bc++] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] m = {{1, 2, 4, 5}, {3, 5, 7, 9}, {12, 4, 6, 8}, {2, 4, 67, 8}};
        zigZagMatrixPrint(m);
    }
}
