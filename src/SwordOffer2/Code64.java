package SwordOffer2;

/**
 * 求 1+2+…+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Code64 {

    public int sumNums(int n) {
        int s = n;
        boolean t = n > 0 && (s += sumNums(n - 1)) > 0;
        return s;
    }
}
