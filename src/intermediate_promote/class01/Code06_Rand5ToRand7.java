package intermediate_promote.class01;

public class Code06_Rand5ToRand7 {

    public static int f() {
        return (int) ((Math.random() * 5) + 1);
    }

    //等概率返回0和1
    public static int r01() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int g() {
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        return res + 1;
    }

    public static int rand01p() {
        double p = 0.84;
        return Math.random() < p ? 0 : 1;
    }

    public static int rand01() {
        int num;
        do {
            num = (rand01p() << 1) + rand01p();
        } while (num == 0 || num == 3);
        return num == 1 ? 0 : 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("result：" + rand01());
        }
    }
}
