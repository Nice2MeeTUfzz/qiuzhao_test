package 小米0906;

import java.util.*;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[][] sum = new int[N][M];
            int[][] minSum = new int[N][M];
            sum[0][0] = matrix[0][0];
            minSum[0][0] = matrix[0][0];

            //填充第一行，只能从左边
            for (int j = 1; j < M; j++) {
                sum[0][j] = sum[0][j - 1] + matrix[0][j];
                minSum[0][j] = Math.min(minSum[0][j - 1], sum[0][j]);
            }
            //填充第一列，只能从上边
            for (int i = 1; i < N; i++) {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
                minSum[i][0] = Math.min(minSum[i][0], sum[i][0]);
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    sum[i][j] = Math.max(sum[i - 1][j], sum[i][j - 1]) + matrix[i][j];
                    int prevMin = Math.max(minSum[i - 1][j], minSum[i][j - 1]);
                    minSum[i][j] = Math.min(sum[i][j], prevMin);
                }
            }
            int minPrefix = minSum[N - 1][M - 1];
            int x = Math.max(1 - minPrefix, 1);
            System.out.println(x);
        }
    }
}
