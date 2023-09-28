1. 
接头密匙
牛牛和他的朋友们约定了一套接头密匙系统，用于确认彼此身份
密匙由一组数字序列表示，两个密匙被认为是一致的，如果满足以下条件：
密匙b的长度不超过密匙a的长度。
对于任意0<=i<length(b),有b[i+1]-b[i]=a[i+1]-a[i]
现在给定了m个密匙b的数组，以及n个密匙a的数组
请你返回一个长度为m的结果数组ans,表示每个密匙b都有多少一致的密匙
数组a和数组b中的元素个数均不超过10^5
1<=m,n<=1000
用前缀树方法：
时间复杂度，0(a数组的数字个数*10)+0(b数组的数字个数*10)
空间复杂度，0(a数组的数字个数*10)，这是树上的节点数量

2.
数组中两个数的最大异或值
给你一个整数数组nums,返回nums[i] XOR nums[j]的最大运算结果，其中O<=i<=j<=n
1 <nums.length <2 10^5 
0<=nums[i]<=2^31-1 
前缀树做法&哈希表做法
时间复杂度0(n*logV,空间复杂度0(n*1ogV,V是数值范围，logV是以10为底

3.
在二维字符数组中搜索可能的单词
给定一个mxn二维字符网格board和一个单词（字符串）列表words
返回所有二维网格上的单词。单词必须按照字母顺序，通过相邻的单元格内的字母构成
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
同一个单元格内的字母在一个单词中不允许被重复使用
1<=m,n<=12
1 <words.Length <3 1044
1 <words[i].length <10
时间复杂度，0(m*n*4^10)
不管用不用前缀树都是这个复杂度，只不过前缀树可以大量剪枝，优化常数时间
空间复杂度，O(words中所有字符串的全部字符数量)
