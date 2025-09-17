package NiuKe;

import java.util.*;

public class BISHI28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int mean = k / n;
        int oth = k % n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < oth) {
                arr[i] = mean+1;
            }else {
                arr[i] = mean;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0;j<n;j++) {
                System.out.print(arr[(j - i + n) % n] + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}
