package 小红书824;

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int[] count = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < n; j++) {
                if (x % scores[j] == 0 || scores[j] % x == 0) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(count[i]);
        }
    }
}
