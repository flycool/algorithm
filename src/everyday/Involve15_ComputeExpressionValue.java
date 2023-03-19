package everyday;

/**
 * 15. 美团
 * ()分值为2 (())分值为3 ((()))分值为4
 * 也就是说，每包裹一层，分数就是里面的分值+1
 * ()()分值为2*2 (())()分值为3*2
 * 也就是说，每连接一段，分数就是各部分相乘，以下是一个结合起来的例子
 * (()())()(())->(2*2+1)*2*3->30
 * 给定一个括号字符串str,已知str一定是正确的括号组合，不会有违规的情况
 * 返回str的分数
 * （递归，返回计算的值和index）
 */
public class Involve15_ComputeExpressionValue {

    public int score(String s) {
        char[] str = s.toCharArray();
        return compute(str, 0)[0];
    }
    // s[i...] 一旦遇到 ')' 或者 字符串终止位置，停
    //int[0]: 负责这一段的结果是多少
    //int[1]: 计算到了什么位置返回
    private int[] compute(char[] s, int i) {
        if (s[i] == ')') {
            return new int[]{1, i};
        }
        int ans = 1;
        while (i < s.length && s[i] != ')') {
            int[] info = compute(s, i + 1);//遇到 '('，递归
            ans *= info[0] + 1;
            i = info[1] + 1;
        }
        return new int[]{ans, i};
    }
}
