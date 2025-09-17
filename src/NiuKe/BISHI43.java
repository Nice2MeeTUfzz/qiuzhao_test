package NiuKe;

import java.util.*;
public class BISHI43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] ap = new long[n];
        long[] bp = new long[n];
        for (int i = 0; i < n; i++) {
            ap[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            bp[i] = sc.nextLong();
        }
        long count = 0L;
        for (int i = 0; i < n; i++) {
            long min = Math.min(ap[i], bp[i]);
            count += min;
        }
        System.out.println(Math.min(count, x));
    }
}
