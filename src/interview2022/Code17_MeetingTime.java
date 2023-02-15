package interview2022;

import interview2022.datastruct.SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 每个会议给定开始和结束时间
 * 后面的会议如果跟前面的会议有任何冲突
 * 完全取消冲突的，之前的会议，安排当前的
 * 给定一个会议数组，返回是否安排的会议列表
 * （线段树）https://github.com/algorithmzuo/algorithmbasic2020/tree/master/src/class31
 */
public class Code17_MeetingTime {

    public ArrayList<int[]> arrange(int[][] meetings) {
        int n = meetings.length;
        int[] rank = new int[n<<1];
        for(int i=0; i<n; i++) {
            rank[i] = meetings[i][0];
            rank[i+n] = meetings[i][1]-1;
        }
        Arrays.sort(rank);
        SegmentTree st = new SegmentTree(n<<1);
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--) {
            int[] cur = meetings[i];
            int from = rank(rank, cur[0]);
            int to = rank(rank, cur[1]);
            if(st.get(from, to) == 0) {
                ans.add(cur);
            }
            st.add(from, to, 1);
        }
        return ans;
    }

    //二分法
    public int rank(int[] rank, int num) {
        return 0;
    }
}
