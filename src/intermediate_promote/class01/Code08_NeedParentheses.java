package intermediate_promote.class01;

public class Code08_NeedParentheses {

    public static int needParentheses(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else { //遇到 ')'
                if (count == 0) {
                    ans++;//单独右括号的数量
                } else{
                    count--;
                }
            }
        }
        return count + ans;
    }

    public static void main(String[] args) {
        String s = "(()(()";
        System.out.println(needParentheses(s));
    }
}
