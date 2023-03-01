package interview2022;

/**
 * 一个数组中只有两种字符'G'和'B'
 * 想让所有的G都放在左侧，所有的B都放在右侧
 * 但是只能在相邻字符之间进行交换操作，
 * 返回至少需要交换几次
 */
public class Code34_SwapGB {

    public int minStep(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step = 0;
        int gi = 0;
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == 'G') {
                step += i - gi;
                gi++;
            }
        }
        return step;
    }
}
