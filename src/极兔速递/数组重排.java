package 极兔速递;

import java.util.HashMap;
import java.util.Scanner;

//</https://codefun2000.com/p/P3805>
public class 数组重排 {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int M = 0;
        while (map.containsKey(M)) {
            M++;
        }

        long maxSum = (long) M * (M + 1) / 2 + (long) (n - M) * M;

        long ways = 1;
        for (int j = 0; j < M; j++) {
            ways = (ways * map.get(j)) % MOD;
        }

        for (int i = 1; i <= n - M; i++) {
            ways = (ways * i) % MOD;
        }

        System.out.println(maxSum + " " +ways);

    }
}
