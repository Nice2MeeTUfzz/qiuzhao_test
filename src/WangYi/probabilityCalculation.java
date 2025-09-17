package WangYi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class probabilityCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        BigDecimal d = sc.nextBigDecimal();
        sc.close();

        // cnt为单元格邻居数量的统计，比如邻居为4的数量:cnt[3]=*
        int[] cnt = new int[9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int x = i + dx;
                        int y = j + dy;
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            v++;
                        }
                    }
                }
                cnt[v - 1]++;
            }
        }

        BigDecimal[] ansArray = new BigDecimal[n * m + 1];
        for (int a = 0; a <= n * m; a++) {
            ansArray[a] = solve(a, n, m, c, d, cnt);
        }

        BigDecimal maxVal = ansArray[0];
        int maxA = 0;
        for (int a = 1; a <= n * m; a++) {
            if (ansArray[a].compareTo(maxVal) > 0) {
                maxVal = ansArray[a];
                maxA = a;
            }
        }

        int b = n * m - maxA;
        System.out.printf("%d %d %.1f%n", maxA, b, maxVal.setScale(1, RoundingMode.HALF_UP));
    }

    private static BigDecimal solve(int a, int n, int m, int c, BigDecimal d, int[] cnt) {
        int totalCells = n * m;
        int b = totalCells - a;

        if (b == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal ans = BigDecimal.ZERO;
        for (int e = 0; e <= 8; e++) {
            if (e + 1 > totalCells) {
                continue;
            }
            BigDecimal[] p = new BigDecimal[e + 1];
            for (int i = 0; i <= e; i++) {
                p[i] = BigDecimal.ZERO;
            }


        }
        return null;
    }
}
