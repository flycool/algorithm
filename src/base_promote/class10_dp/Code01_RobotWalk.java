package base_promote.class10_dp;

public class Code01_RobotWalk {

    public static int walkWays(int N, int E, int K, int S) {
        return f(N, E, K, S);
    }

    public static int f(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return f(N, E, rest - 1, 2);
        }
        if (cur == N) {
            return f(N, E, rest - 1, N - 1);
        }
        return f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
    }

    public static int walkWaysDp(int N, int E, int K, int S) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return fdp(N, E, K, S, dp);
    }

    public static int fdp(int N, int E, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
        } else if (cur == 1) {
            dp[rest][cur] = f(N, E, rest - 1, 2);
        } else if (cur == N) {
            dp[rest][cur] = f(N, E, rest - 1, N - 1);
        } else {
            dp[rest][cur] = f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
        }
        return dp[rest][cur];
    }
}
