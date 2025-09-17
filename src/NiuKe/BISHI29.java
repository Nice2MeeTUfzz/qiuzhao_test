package NiuKe;

import java.util.*;

public class BISHI29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println(-1);
            return;
        }

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
        }
        if (n % 2 == 1) {
            p[0] = p[n - 1];
            p[n - 1] = 1;
            p[1] = p[n - 2];
            p[n - 2] = 2;
        }

        if (n % 2 == 0) {
            p[0] = p[n - 2];
            p[n - 2] = 1;
            p[1] = p[n - 1];
            p[n - 1] = 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + " ");
        }
    }
}
