package base.class03_binarytree;

public class PageFold {

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.print(down ? "凹" : "凸");//利用中序遍历
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);

    }
}
