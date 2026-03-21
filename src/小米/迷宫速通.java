package 小米;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 迷宫速通 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // dp[i][j] 表示进入 (i,j) 之前所需的最小积分
            int[][] dp = new int[N + 1][M + 1];
            dp[N][M] = Math.max(1, 1 - arr[N][M]);
            for (int j = M - 1; j >= 1; j--) {
                dp[N][j] = Math.max(1, dp[N][j + 1] - arr[N][j]);
            }

            for (int i = N - 1; i >= 1; i--) {
                dp[i][M] = Math.max(1, dp[i + 1][M] - arr[i][M]);
            }

            for (int i = N - 1; i >= 1; i--) {
                for (int j = M - 1; j >= 1; j--) {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - arr[i][j]);
                }
            }

            System.out.println(dp[1][1]);
        }
    }
}
