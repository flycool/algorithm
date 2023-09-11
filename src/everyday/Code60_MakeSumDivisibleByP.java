package everyday;

import java.util.HashMap;

/**
 * 60 来自谷歌、字节跳动
 * 给你一个正整数数组nums,请你移除最短子数组（可以为空）
 * 使得剩余元素的和能被p整除。不允许将整个数组都移除。
 * 请你返回你需要移除的最短子数组的长度，
 * 如果无法满足题目要求，返回-1。
 * 子数组定义为原数组中连续的一组元素。
 * 测试链接：https://leetcode.cn/problems/make-sum-divisible-by-p/
 */
public class Code60_MakeSumDivisibleByP {

    public int minSubArray(int[] nums, int p) {
        int n = nums.length;
        int allMod = 0;
        for (int num : nums) {
            allMod = (allMod + num) % p;
        }
        if (allMod == 0) {
            return 0;
        }
        //某个余数(key)对应的最晚的前缀和(value)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = Integer.MAX_VALUE;
        int curMod = 0;
        int find;
        for (int i = 0; i < n; i++) {
            curMod = (curMod + nums[i]) % p;
            find = (curMod - allMod + p) % p;
            if (map.containsKey(find)) {
                ans = Math.min(ans, i - map.get(find));
            }
            map.put(curMod, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}
