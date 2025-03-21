package zuo2025.algorithm;

// 威佐夫博弈(Wythoff Game)
// 有两堆石子，数量任意，可以不同，游戏开始由两个人轮流取石子
// 游戏规定，每次有两种不同的取法
// 1) 在任意的一堆中取走任意多的石子
// 2) 可以在两堆中同时取走相同数量的石子
// 最后把石子全部取完者为胜者
// 现在给出初始的两堆石子的数目，返回先手能不能获胜
// 测试链接 : https://www.luogu.com.cn/problem/P2252
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigDecimal;

public class Code06_WythoffGame {

	// 黄金分割比例
	// 洛谷在2024年5月增加了测试数据
	// 需要更高精度的黄金比例 + 更高精度的乘法，才能全部通过
	// 增加的测试用例有刻意为难的嫌疑，其实没啥意思
	// Java就用BigDecimal类型支持高精度，C++同学可以用long double类型
	public static BigDecimal split = new BigDecimal("1.61803398874989484");

	public static int a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			a = (int) in.nval;
			in.nextToken();
			b = (int) in.nval;
			out.println(compute());
			out.flush();
		}
		out.close();
		br.close();
	}

	public static int compute() {
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		// 威佐夫博弈
		// 小 != (大 - 小) * 黄金分割比例，先手赢
		// 小 == (大 - 小) * 黄金分割比例，后手赢
		// 要向下取整
		// 这里用BigDecimal类型的multiply方法，乘完后再转成整型，可以支持高精度的乘
		if (min != split.multiply(new BigDecimal(max - min)).intValue()) {
			return 1;
		} else {
			return 0;
		}
	}

}
