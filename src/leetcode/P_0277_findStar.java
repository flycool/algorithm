package leetcode;

public class P_0277_findStar {

    //系统给定函数
    //know(i, j) i认识j，返回true，
    public boolean know(int i, int j) {
        return true;
    }

    public int findStar(int n) {
        int cand = 0;
        for (int i = 0; i < n; i++) {
            if (know(cand, i)) {
                cand = i;
            }
        }
        //验证
        //1 cand是不是认识所有人 (右侧的人cand都不认识)
        for (int i = 0; i < cand; i++) {
            if (know(cand, i)) {
                return -1;
            }
        }
        //2 所有人是不是认识cand
        for (int i = 0; i < n; i++) {
            if (!know(i, cand)) {
                return -1;
            }
        }
        return cand;
    }
}
