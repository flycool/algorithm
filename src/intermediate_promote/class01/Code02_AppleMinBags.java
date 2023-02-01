package intermediate_promote.class01;

public class Code02_AppleMinBags {

    //有两种类型的袋子，6和8，只能装6个或8个，输入一个整数n，返回最小使用的袋子
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest >= 24) {
            int reqBag6 = minBagBase6(rest);
            if (reqBag6 != -1) {
                bag6 = reqBag6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    private static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    //打表法
    //根据返回值的规律，得到答案
    public static int minBagsAwesome(int apple) {
        if ((apple & 1) != 0) {// 奇数，返回-1
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;

    }
}
