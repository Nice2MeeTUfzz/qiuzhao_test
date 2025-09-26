package 滴滴0826;

/**
 * https://codefun2000.com/p/P3477
 */

import java.util.*;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = map[0][0];
            for (int j = 1; j < n + 1; j++) {
                dp[0][j] = dp[0][j - 1] + map[0][j - 1];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1] + map[i][j - 1], dp[i - 1][j]);
                }
            }
            int maxVal = dp[0][n];
            for (int i = 0; i < n; i++) {
                if (dp[i][n] > maxVal) {
                    maxVal = dp[i][n];
                }
            }
            System.out.println(maxVal);
        }
    }
}
