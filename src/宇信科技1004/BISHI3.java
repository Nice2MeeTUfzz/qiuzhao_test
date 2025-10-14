package 宇信科技1004;

import java.util.Scanner;

public class BISHI3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = 0;
        String str = sc.next();
        long[] count = new long[n];
        long[] counth = new long[n];
        long sum = 0;
        long sumh = 0;
        for (int i = n-1; i >= 0; i--) {
            if (str.charAt(i) == 'y') {
                sum++;
            }
            count[i] = sum;
            if (str.charAt(i) == 'h') {
                sumh += sum;
            }
            counth[i] = sumh;
        }
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != 's') {
                continue;
            }
            result += counth[i];
        }
        System.out.println(result);
    }
}
