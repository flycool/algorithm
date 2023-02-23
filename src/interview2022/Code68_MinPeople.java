package interview2022;

import java.util.Arrays;

/**
 * 68 鹅厂文化衫问题
 * c/(x+1) 向上取整 即 ((c+x)/(x+1))
 *  ans = ((c+x)/(x+1))*(x+1)
 */
public class Code68_MinPeople {

    public int minPeople(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int x = arr[0];
        int c = 1;
        int ans = 0;
        //x...x c个
        //y...y k个
        for (int i = 0; i < n; i++) {
            if (x != arr[i]) {
                ans += ((c + x) / (x + 1)) * (x + 1);
                x = arr[i];
                c = 1;
            } else {
                c++;
            }
        }
        return ans + ((c + x) / (x + 1)) * (x + 1);
    }
}
