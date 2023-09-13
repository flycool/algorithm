package everyday;

/**
 * 63 来自美团
 * 给定pushed和popped两个序列，每个序列中的值都不重复
 * 只有当它们可能是在最初空栈上进行的推入push和弹出pop操作
 * 序列的结果时
 * 返回true;否则，返回false
 * 测试链接：https://leetcode.cn/problems/validate-stack-sequences/
 * <p>
 * 栈顶不一样的就压入，一样的就弹出
 */
public class Code63_ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int size = 0;
        for (int i = 0, j = 0; i < n; i++) {
            pushed[size++] = pushed[i];
            // 每压入一个数，就不断的检查是否要弹出
            while (size > 0 && j < n && pushed[size - 1] == popped[j]) {
                size--;
                j++;
            }
        }
        return size == 0;
    }
}
