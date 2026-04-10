package 美团;

import java.util.Scanner;

// https://codefun2000.com/p/P4675
public class 交替子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            // dp[i][0] -> 前i个元素中，以 + 结尾的最大和
            // dp[i][1] -> 前i个元素中，以 - 结尾的最大和
            long[][] dp = new long[n][2];
            dp[0][0] = arr[0];
            dp[0][1] = Long.MIN_VALUE / 2;
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][1] + arr[i], Math.max(dp[i-1][0], arr[i]));
                dp[i][1] = Math.max(dp[i-1][0] - arr[i], dp[i-1][1]);
            }
            long maxVal = Math.max(dp[n-1][0], dp[n-1][1]);
            System.out.println(maxVal);
        }
    }
}
