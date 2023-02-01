package intermediate_promote.class06;

public class Code04_SubArrayMaxSum {

      //子数组最大累加和问题
      //假设答案法

      /**
       * 假设答案在[i...j], 累加和最大，且长度最长
       * 1)[i...end<j] >=0 i到j之间的累加和大于等于0
       * 2)[?...i-1] < 0 任意开头到i-1的累加和小于0
       * 所以cur到i时，cur为(0+i),累加到j时，max最大
       */
      public static int maxSum(int[] arr) {
            if (arr == null || arr.length == 0) {
                  return 0;
            }
            int cur = 0;
            int max = Integer.MIN_VALUE;
            for (int j : arr) {
                  cur += j;
                  max = Math.max(cur, max);
                  cur = Math.max(cur, 0);
            }
            return max;
      }
}
