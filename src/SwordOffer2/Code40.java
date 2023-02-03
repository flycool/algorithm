package SwordOffer2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的 k 个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Code40 {

    public static int[] getLeastNumbers(int[] nums, int k) {
        Arrays.sort(nums);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        return ans;
    }

    public static int[] getLeastNumbers2(int[] nums, int k) {
        //优先队列，大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int[] ints = getLeastNumbers(nums, 2);
        System.out.println(ints);
    }
}
