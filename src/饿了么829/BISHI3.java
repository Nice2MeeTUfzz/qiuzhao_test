package 饿了么829;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.time.MonthDay;
import java.util.*;
public class BISHI3 {
    static final int MOD = 1000000007;
    // 计算(a^b)%mod
    static long pow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res*a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        int m = 0;
        for (char c : s.toCharArray()) {
            if (c == 'X') {
                m++;
            }
        }

        long total = pow(2, m, MOD);

        long[] prev = new long[k];
        prev[0] = 1;
        long sumPrev = 1;
        for(char c: s.toCharArray()){
            long[] curr = new long[k];
            long sumCurr = 0;
            if (c == 'B') {
                for (int j = 1; j < k; j++) {
                    curr[j] = prev[j - 1];
                }

                for (int j = 1; j < k; j++) {
                    sumCurr += (sumCurr + curr[j]) % MOD;
                }
            }
        }
    }
}
