package SwordOffer2;

/**
 * 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Code53_1 {

    public static int findNumInArray(int[] array, int target) {
        int n = array.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == target) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int i = findNumInArray(a, 5);
        System.out.println(i);
    }
}
