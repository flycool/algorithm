package everyday;

import java.util.HashMap;

/**
 * 3. 小红书
 * 有四种诗的韵律分别为:AABB、ABAB、ABBA、AAAA
 * 比如:1133就属于AABB型的韵律、6666就属于AAAA型的韵律等等
 * 一个数组当然可以生成很多的子序列,
 * 如果某个子序列一直以韵律的方式连接起来,我们称这样的子序列是有效的
 * 比如,arr={1,1,15,1,34,1,2,67,3,3,2,4,15,3,17,4,3,7,52,7,81,9,9}
 * arr的一个子序列为{1,1,1,1,2,3,3,2,4,3,4,3,7,7,9,9}
 * 其中1,1,1,1是AAAA、2,3,3,2是ABBA、4,3,4,3是ABAB、7,7,9,9是AABB
 * 可以看到,整个子序列一直以韵律的方式连接起来,所以这个子序列是有效的
 * 给定一个数组arr,返回最长的有效子序列长度
 */
public class Involve03_Poem {

    public int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //表示有多少数出现2次
        int two = 0;
        int ans = 0;
        int numTimes = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            numTimes = map.get(num);
            two += numTimes == 2 ? 1 : 0;
            // 符合韵律的组合，出现2种2个的数字 和 4个一样的数
            if (two == 2 || numTimes == 4) {
                ans += 4;
                // 清空，重新循环
                map.clear();
                two = 0;
            }
        }
        return ans;
    }
}
