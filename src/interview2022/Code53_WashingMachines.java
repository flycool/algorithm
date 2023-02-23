package interview2022;

/**
 * 53.超级洗衣机问题
 * 给定一个数组arr代表洗衣机，arr[i]表示衣物的数量
 * 每个洗衣机可以向左或向右扔一件衣物
 * 返回多少步，能平均衣物的数量
 */
public class Code53_WashingMachines {

    public int findMinMoves(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        if (sum % size != 0) {//没有平均
            return -1;
        }
        int avg = sum / size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
            //代价最大的就是需要的次数（结论）
            if (leftRest < 0 && rightRest < 0) {
                // 都小于0，就相加
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                // 否则，取大的值
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }
}
