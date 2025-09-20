package 美团0920;

import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        long[] ai = new long[n];
        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextLong();
        }
        while(q-- > 0) {
            long x = sc.nextLong();
            long Max = 0;
            for (int i = 0; i < n; i++) {
                long temp = ai[i % n] * x * x + ai[(i + 1) % n] * x + ai[(i + 2) % n];
                temp = temp % m;
                if (temp > Max) {
                    Max = temp;
                }
            }
            System.out.print(Max + " ");
        }
    }
}
