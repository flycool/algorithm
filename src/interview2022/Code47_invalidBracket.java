package interview2022;

import java.util.List;

//47 无效括号串变有效的所有可能结果
public class Code47_invalidBracket {

    // par: ( )
    public void remove(String s, List<String> ans, int checkIndex, int deleteIndex, char[] par) {
        for (int count = 0, i = checkIndex; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) { // == '('
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                for (int j = deleteIndex; j <= i; j++) {
                    if (s.charAt(j) == par[1] && (j == deleteIndex || s.charAt(j - 1) != par[1])) {
                        //删除j位置的括号
                        remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}
