package zuo2025.algorithm;

// 墨墨的等式(两次转圈法)
// 一共有n种正数，每种数可以选择任意个，个数不能是负数
// 那么一定有某些数值可以由这些数字累加得到
// 请问在[l...r]范围上，有多少个数能被累加得到
// 0 <= n <= 12
// 0 <= 数值范围 <= 5 * 10^5
// 1 <= l <= r <= 10^12
// 测试链接 : https://www.luogu.com.cn/problem/P2371
// 提交以下的code，提交时请把类名改成"Main"，可以通过所有测试用例

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Code04_MomoEquation2 {

	public static int MAXN = 500001;

	public static long inf = Long.MAX_VALUE;

	public static int[] v = new int[MAXN];

	public static long[] dist = new long[MAXN];

	public static int n, x;

	public static long l, r;

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static long compute() {
		Arrays.sort(v, 1, n + 1);
		int size = 0;
		for (int i = 1; i <= n; i++) {
			if (v[i] != 0) {
				v[++size] = v[i];
			}
		}
		if (size == 0) {
			return 0;
		}
		x = v[1];
		Arrays.fill(dist, 0, x, inf);
		dist[0] = 0;
		for (int i = 2, d; i <= size; i++) { // 出现基准数之外的其他数，更新最短路
			d = gcd(v[i], x); // 求最大公约数
			for (int j = 0; j < d; j++) { // j是每个子环的起点
				for (int cur = j, next, circle = 0; circle < 2; circle += cur == j ? 1 : 0) {
					next = (cur + v[i]) % x;
					if (dist[cur] != inf) {
						dist[next] = Math.min(dist[next], dist[cur] + v[i]);
					}
					cur = next;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i < x; i++) {
			if (r >= dist[i]) {
				ans += Math.max(0, (r - dist[i]) / x + 1);
			}
			if (l >= dist[i]) {
				ans -= Math.max(0, (l - dist[i]) / x + 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		in.nextToken();
		l = (long) in.nval - 1;
		in.nextToken();
		r = (long) in.nval;
		for (int i = 1; i <= n; i++) {
			in.nextToken();
			v[i] = (int) in.nval;
		}
		out.println(compute());
		out.flush();
		out.close();
		br.close();
	}

}
