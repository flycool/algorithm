package everyday;

/**
 * 32 亚马孙
 * 给定一个整数数组A，坡是元组(i,j)，其中i<j且a[i]<=a[j]
 * 这样的坡的宽度为 j-i
 * 找出A中的坡的最大宽度，如果不存在，返回0
 * 示例1:
 * 输入:[6,0,8,2,1,5]
 * 输出:4
 * 解释:
 * 最大宽度的坡为(i,j)=(1,5):a[1]=0且A[5]=5
 * 示例2:
 * 输入:[9,8,1,0,1,9,4,0,4,1]
 * 输出:7
 * 解释:
 * 最大宽度的坡为(i,j)=(2,9):A[2]=1且A[9]=1
 * 测试链接:https://leetcode.cn/problems/maxumum-width-ramp/
 * (单调栈)
 */
public class Code32_maxWidthRamp {

    public int maxWidthRamp(int[] arr) {
        int n = arr.length;
        int[] stack = new int[n];//存arr下标
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r == 0 || arr[stack[r - 1]] > arr[i]) {
                stack[r++] = i;
            }
        }
        int ans = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (r != 0 && stack[r - 1] <= arr[j]) {
                int i = stack[--r];
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}
