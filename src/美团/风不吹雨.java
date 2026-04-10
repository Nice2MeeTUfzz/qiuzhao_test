package 美团;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://codefun2000.com/p/P4674
// 3
// 3 1 1 3
// 5 1 7
// 1 1 1 5
// 9
// 1 0 1 10
// 3

public class 风不吹雨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            Long[] arr = new Long[n];
            int totalSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                totalSum += arr[i];
            }

            Long[] _arr = new Long[n];
            for (int i = 0; i < n; i++) {
                _arr[i] = arr[i] - Math.floorDiv(arr[i], 2);
            }

            Arrays.sort(_arr, Collections.reverseOrder());
            long sum_meth1 = 0;

            for (int i = 0; i < Math.min(n, a); i++) {
                if (_arr[i] > 0) {
                    sum_meth1 += _arr[i];
                }
            }

            long sum_meth2 = 0;
            if (k > 0) {
                sum_meth2 = (long) Math.min(b, n) * k;
            }
            System.out.println(totalSum - sum_meth1 - sum_meth2);
        }
    }
}
