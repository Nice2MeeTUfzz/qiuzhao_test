package 恒生电子;

import java.math.BigInteger;
import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int m = sc.nextInt();
            int k = sc.nextInt();
            if (m == 1) {
                System.out.println(9 + " " + 0);
                continue;
            }

            int[] minvals = new int[m];
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    minvals[i] = 1;
                } else {
                    minvals[i] = 0;
                }
            }
            long minVal = 0;
            long plus = 1;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < m - i - 1; j++) {
                    plus *= 10;
                }
                minVal += (minvals[i] * plus) % k;
            }

            System.out.println(minVal % k);
        }
    }
}
