package NiuKe;

import java.util.*;

public class BISHI46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int cost = 0;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            b[i] = a[x1] + a[x2];
            cost += Math.min(b[i], a[i]);
        }
        System.out.println(cost);
    }
}
