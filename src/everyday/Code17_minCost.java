package everyday;

/**
 * 17 来自网易
 * 小红拿到了一个仅由r、e、d组成的字符串
 * 她定义一个字符e为"好e"：当且仅当这个e字符和r、d相邻
 * 例如"reeder"只有一个"好e"，前两个e都不是"好e"，只有第三个e是"好e”
 * 小红每次可以将任意字符修改为任意字符，即三种字符可以相互修改
 * 她希望“好e”的数量尽可能多小红想知道，自己最少要修改多少次
 * 输入一个只有r、e、d三种字符的字符串
 * 长度<=2*10^5
 * 输出最小修改次数
 */
public class Code17_minCost {

    public int minCost(String s) {
        int n = s.length();
        if (n < 3) {
            return -1;
        }
        int[] arr = new int[n];
        //d-->0, e-->1, r-->2
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == 'd') {
                arr[i] = 0;
            } else if (cur == 'e') {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        int maxGood = 0;
        int minCost = Integer.MAX_VALUE;
        for (int prepre = 0; prepre < 3; prepre++) {
            for (int pre = 0; pre < 3; pre++) {
                int cost = arr[0] == prepre ? 0 : 1;
                cost += arr[1] == pre ? 0 : 1;
                Info curInfo = process(arr, 2, prepre, pre);
                if (curInfo.value > maxGood) {
                    maxGood = curInfo.value;
                    minCost = curInfo.cost + cost;
                } else if (curInfo.value == maxGood) {
                    minCost = Math.min(minCost, curInfo.cost) + cost;
                }

            }
        }
        return minCost;
    }

    public Info process(int[] arr, int i, int prepre, int pre) {
        if (i == arr.length) {
            return new Info(0, 0);
        }
        //arr[i]==0
        int curValue1 = prepre == 2 && pre == 1 ? 1 : 0;
        int curCost1 = arr[i] == 0 ? 0 : 1;
        Info info1 = process(arr, i + 1, pre, 0);
        //arr[i]==1
        int curValue2 = 0;
        int curCost2 = arr[i] == 1 ? 0 : 1;
        Info info2 = process(arr, i + 1, pre, 1);
        //arr[i]==2
        int curValue3 = prepre == 0 && pre == 1 ? 1 : 0;
        int curCost3 = arr[i] == 2 ? 0 : 1;
        Info info3 = process(arr, i + 1, pre, 2);

        int p1value = curValue1 + info1.value;
        int p1Cost = curCost1 + info1.cost;
        int p2value = curValue2 + info2.value;
        int p2Cost = curCost2 + info2.cost;
        int p3value = curValue3 + info3.value;
        int p3Cost = curCost3 + info3.cost;

        int bestValue = 0, minCost = Integer.MAX_VALUE;
        if (bestValue > p1value) {
            bestValue = p1value;
        } else if (bestValue == p1value) {
            minCost = Math.min(minCost, p1Cost);
        }
        if (bestValue > p2value) {
            bestValue = p2value;
        } else if (bestValue == p2value) {
            minCost = Math.min(minCost, p2Cost);
        }
        if (bestValue > p3value) {
            bestValue = p3value;
        } else if (bestValue == p3value) {
            minCost = Math.min(minCost, p3Cost);
        }
        return new Info(bestValue, minCost);
    }


    class Info {
        public int value;
        public int cost;

        public Info(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
