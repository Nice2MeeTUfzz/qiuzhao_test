package 滴滴0308;

import java.util.Scanner;

public class 不等式问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long count = 0;
            int n = sc.nextInt();
            int x = sc.nextInt();
            for (int a = 1; a < x - 1; a++) {
                if (2 * a + 1 > n) break;
                for (int b = 1; b < x - a; b++) {
                    if (a * b + b + a > n) break;
                    int c1 = (n - a * b) / (a + b);
                    int c2 = x - a - b;
                    count += Math.min(c1, c2);
                }
            }
            sb.append(count).append("/n");
        }
        System.out.println(sb);
    }
}
