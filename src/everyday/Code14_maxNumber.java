package everyday;

import java.util.Arrays;

/**
 * 14 字节
 * 去重数组arr，里面的数只包含0~9
 * limit，一个数字
 * 返回：要求比limit小的情况下，能够用arr拼出来的最大数字
 */
public class Code14_maxNumber {

    public int maxNumber(int[] arr, int limit) {
        Arrays.sort(arr);
        limit--;
        int offset = 1;
        //limit: 68886
        //offset:10000
        while (offset <= limit / 10) {
            offset *= 10;
        }
        //如果做不到和limit位数一样，返回-1
        int ans = process(arr, limit, offset);
        if (ans != -1) {
            return ans;
        } else {// ans=-1，则需减少位数
            offset /= 10;
            int rest = 0;
            while (offset > 0) {
                rest += arr[arr.length - 1] * offset;
                offset /= 10;
            }
            return rest;
        }
    }

    public int process(int[] arr, int limit, int offset) {
        if (offset == 0) {
            return limit;
        }
        //取出当前数字
        int cur = (limit / offset) % 10;
        //arr中最接近cur的index
        int nearIndex = near(arr, cur);
        if (nearIndex == -1) {
            return -1;
        } else if (arr[nearIndex] == cur) {
            int ans = process(arr, limit, offset / 10);
            if (ans == -1) {
                return -1;
            } else if (nearIndex > 0) {//可以降位
                nearIndex--;
                return (limit / (offset * 10)) * offset * 10 + (arr[nearIndex] * offset) + rest(arr, offset / 10);
            } else {
                return -1;
            }
        } else {
            return (limit / (offset * 10)) * offset * 10 + (arr[nearIndex] * offset) + rest(arr, offset / 10);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8};
        int rest = rest(arr, 100);
        System.out.println(rest);
    }

    private static int rest(int[] arr, int offset) {
        int lastIndex = arr.length - 1;
        int ans = 0;
        while (offset > 0) {
            offset /= 10;
            ans += arr[lastIndex] * offset;
        }
        return ans;
    }

    private int near(int[] arr, int cur) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= cur) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
