package NiuKe;

import java.util.*;

public class BISHI25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 1) {
            System.out.println(0);
            return;
        }

        long p = in.nextLong();
        long i = 1;
        long maxU = p * p + i * i;
        long minU = maxU;
        long maxV = p * p - i * i;
        long minV = maxV;
        for (i = 2; i <= n; i++) {
            p = in.nextLong();
            long u = p * p + i * i;
            long v = p * p - i * i;
            maxU = Math.max(maxU, u);
            minU = Math.min(minU, u);
            maxV = Math.max(maxV, v);
            minV = Math.min(minV, v);
        }

        System.out.println(Math.max(maxU - minU, maxV - minV));
    }
}
