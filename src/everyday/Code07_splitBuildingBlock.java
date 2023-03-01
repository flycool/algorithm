package everyday;

import java.util.Arrays;

/**
 * 5. 京东
 * 小明手中有n块积木，并且小明知道每块积木的重量
 * 现在小明希望将这些积木堆起来
 * 要求是任意一块积木如果想堆在另一块积木上面，那么要求：
 * 1 上面的积木重量不能小于下面的积木重量
 * 2 上面积木的重量减去下面积木的重量不能超过x
 * 3 没堆中最下面的积木没有重量要求
 * 现在小明有一个机会，除了这n块积木，还可以获得k块任意重量的积木
 * 小明希望将积木堆在一起，同时希望积木堆的数量越少越好，你能帮他找到最好的方案么？
 */
public class Code07_splitBuildingBlock {

    public int minSplit(int[] arr, int k, int x) {
        int n = arr.length;
        Arrays.sort(arr);
        int splits = 0;
        int[] needs = new int[n];
        int size = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > x) {// 大于x，另起一堆
                needs[size++] = arr[i] - arr[i - 1];
                splits++;
            }
        }
        if (splits == 1 || x == 0 || k == 0) {
            return splits;
        }
        Arrays.sort(needs, 0, size);
        for (int i = 0; i < size; i++) {
            int need = (needs[i] - 1) / x;
            if (k >= need) {
                splits--;
                k -= need;
            } else {
                break;
            }
        }
        return splits;
    }
}
