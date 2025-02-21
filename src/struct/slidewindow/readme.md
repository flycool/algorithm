
滑动窗口： 维持左右边界都不回退的一段范围，来求解很多子数组（串）的相关问题
滑动窗口的关键： 找到 范围 和 答案指标 之间的 单调性关系（类似贪心）
滑动过程： 滑动窗口可以用 简单变量 或者 结构 来维护信息

求解大流程：求子数组在 每个位置开头或结尾 情况下的答案（开头还是结尾在于个人习惯）

注意：滑动窗口维持最大值或最小值的 更新结构


1.  
累加和大于等于target的最短子数组长度
给定一个含有n个正整数的数组和一个正整数target
找到累加和>=target的长度最小的子数组并返回其长度
如果不存在符合条件的子数组返回0
测试链接：https://leetcode.cn/problems/minimum-size-subarray-sum/

2. 
无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
测试链接：https://leetcode.cn/problems/Longest-substring-without-repeating-characters/

3. 
最小覆盖子串
给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串
如果中不存在涵盖t所有字符的子串，则返回空字符串""。
测试链接：https://leetcode.cn/problems/minimum-window-substring/

4. 
加油站
在一条环路上有n个加油站，其中第i个加油站有汽油gas[i]升。
你有一辆油箱容量无限的的汽车，
从第i个加油站开往第i+1个加油站需要消耗汽油cost[i]升
你从其中的一个加油站出发，开始时油箱为空。
给定两个整数数组gas和cost,如果你可以按顺序绕环路行驶一周
则返回出发时加油站的编号，否则返回-1
如果存在解，则保证它是唯一的。
测试链接：https://leetcode.cn/problems/gas-station/

5. 
替换子串得到平衡字符串
有一个只含有'Q','W','E','R'四种字符，且长度为n的字符串。
假如在该字符串中，这四个字符都恰好出现4次，那么它就是一个「平衡字符串」。
给你一个这样的字符串，请通过「替换一个子串」的方式，
使原字符串s变成一个「平衡字符串」。
你可以用和「待替换子串」长度相同的任何其他字符串来完成替换。
请返回待替换子串的最小可能长度。
如果原字符串自身就是一个平衡字符串，则返回0。
测试链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string/

6. 
K个不同整数的子数组
给定一个正整数数组nums和一个整数k,返回nums中「好子数组」的数目。
如果nums的某个子数组中不同整数的个数恰好为k
则称nums的这个连续、不一定不同的子数组为「好子数组」。
例如，[1,2,3,1,2]中有3个不同的整数：1,2，以及3。
子数组是数组的连续部分。
测试链接：https://leetcode.cn/problems/subarrays-with-k-different-integers/

7. 
至少有K个重复字符的最长子串
给你一个字符串S和一个整数k,请你找出s中的最长子串
要求该子串中的每一字符出现次数都不少于k。返回这一子串的长度
如果不存在这样的子字符串，则返回0。
测试链接：https://leetcode.cn/problems/Longest-substring-with-at-Least-k-repeating-characters/