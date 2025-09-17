package NiuKe;

import java.util.*;

public class BISHI48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        long sum = 0;
        for (int i = n - 1; i > 0; i--) {
            if (Math.abs(list[i] - list[i - 1]) <= k) {
                sum += (long) list[i] * list[i - 1];
                i--;
            }
        }
        System.out.println(sum);
    }
}
