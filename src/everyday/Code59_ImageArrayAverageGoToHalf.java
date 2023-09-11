package everyday;

/**
 * 59 来自华为OD
 * 一个图像有n个像素点，存储在一个长度为n的数组arr里，
 * 每个像素点的取值范围[0，s]的整数
 * 请你给图像每个像素点值加上一个整数k(可以是负数)
 * 像素值会自动截取到[0，S]范围，
 * 当像素值<0，会更改为0，当新像素值>S,会更改为S
 * 这样就可以得到新的arr,想让所有像素点的平均值最接近中位值s/2,向下取整
 * 请输出这个整数k,如有多个整数k都满足，输出小的那个
 * 1<=n<=10^6
 * 1<=S<=10^18
 */
public class Code59_ImageArrayAverageGoToHalf {

    public int getMinK(int[] arr, int s) {
        int l = -s;
        int r = s;
        int half = s / 2;
        int del = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int k = (l + r) / 2;
            int avg = avg(arr, s, k);
            int absDel = Math.abs(avg - half);

            if (absDel < del || (absDel == del && k < ans)) {
                del = avg-half;
                ans = k;
            }

            if (avg >= half) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return ans;
    }

    private int avg(int[] arr, int s, int k) {
        int sum = 0;
        for (int i : arr) {
            int v = i + k;
            if (v <= 0) {
                sum += 0;
            } else if (v > s) {
                sum += s;
            } else {
                sum += i;
            }
        }
        return sum / arr.length;
    }
}
