package 饿了么0913;

import java.util.*;

/**
 * 题目内容
 * 给定整数n、m、k，请你在n行m列的网格中填入整数，使得:
 * 每个格子填入的整数在1到k之间;
 * 每个整数恰好出现n*m/k次;
 * 对于每个a [1,k],编号为a的格子构成的连通块（基于四相邻）是连通的.
 * 名词解释：四相邻：在这里，当|x-x'|+|y-y'|==1时，单元格(x,y)和(x',y')被认为是相邻的.
 * 输入描述
 * 第一行输入一个整数 t (1 ≤ t ≤ 10^4),表示测试用例数.
 * 接下来t行,每行输入三个整数n、m、k, 满足(2 ≤ n·m ≤ 2x10^5)、且n·m = 0(mod k)，保证所有测试用例中Σn·m ≤ 3x10^5
 * 输出描述
 * 对于每个测试用例，输出n行，每行m个整数，表示一种满足条件的网格填充方案。如果存在多个解决方案，你可以
 * 输出任意一个，系统会自动判定是否正确。注意，自测运行功能可能因此返回错误结果，请自行检查答案正确性。
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int s = (n * m) / k;
            int[][] g = new int[n][m];
            int cur = 1, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < m; j++) {
                        g[i][j] = cur;
                        cnt++;
                        if (cnt == s) {
                            cur++;
                            cnt = 0;
                        }
                    }
                }else {
                    for (int j = m - 1; j >= 0; j--) {
                        g[i][j] = cur;
                        cnt++;
                        if (cnt == s) {
                            cur++;
                            cnt = 0;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j > 0) {
                        sb.append(' ');
                    }
                    sb.append(g[i][j]);
                }
                sb.append('\n');
            }
            System.out.print(sb.toString());
        }
    }
}
