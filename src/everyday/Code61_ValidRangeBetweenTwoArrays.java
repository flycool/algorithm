package everyday;

/**
 * 61
 * 来自微众银行
 * 给出两个长度均为n的数组
 * A={a1,a2,...,an}
 * B={b1,b2,..,bn}。
 * 你需要求出其有多少个区间[L,R]满足：
 * 数组A中下标在[L,R]中的元素之和在[La,Ra]之中
 * 数组B中下标在[L,R]中的元素之和在[Lb,Rb]之中
 *
 * 输入
 * 第一行有一个正整数N(1<=N<=100000),代表两个数组的长度。
 * 第二行有N个非负整数，范围在0到1000000000之间，代表数组中的元素。
 * 第三行有N个非负整数，范围在0到1000000000之间，代表数组中的元素。
 * 第四行有4个整数La,Ra,Lb,Rb,范围在0到10^18之间，代表题目描述中的参数。
 * 输出
 * 一个整数，代表所求的答案。
 *
 * 两个滑动窗口
 */
public class Code61_ValidRangeBetweenTwoArrays {

    public int getNums(int[] A, int[] B, int la, int ra, int lb, int rb) {
        int n = A.length;
        int ans = 0;
        int sumA1 = 0, sumA2 = 0;
        int rightA1 = 0, rightA2 = 0;
        int sumB1 = 0, sumB2 = 0;
        int rightB1 = 0, rightB2 = 0;
        for (int i = 0; i < n; i++) {
            while (rightA1 < n && (sumA1 + A[rightA1]) < la) {
                sumA1 += A[rightA1++];
            }
            while (rightA2 < n && (sumA2 + A[rightA2]) <= ra) {
                sumA2 += A[rightA2++];
            }
            while (rightB1 < n && (sumB1 + B[rightB1]) < lb) {
                sumB1 += B[rightB1++];
            }
            while (rightB2 < n && (sumB2 + B[rightB2]) <= rb) {
                sumB2 += B[rightB2++];
            }
            int left = Math.max(rightA1, rightB1);
            int right = Math.max(rightA2, rightB2);
            if (left < right) {
                ans += right - left;
            }
            // 窗口移动时，累加和的变化
            if (rightA1 == i) {
                rightA1++;
            } else {
                sumA1 -= A[i];
            }
            sumA2 -= A[i];
            if (rightB1 == i) {
                rightB1++;
            } else {
                sumB1 -= B[i];
            }
            sumB2 -= B[i];
        }
        return ans;
    }
}
