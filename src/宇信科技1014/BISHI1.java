package 宇信科技1014;

import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == A) {
                sumA++;
            } else if (a == B) {
                sumB++;
            }
        }
        float a_poss = (float) sumA / n;
        float b_poss = (float) sumB / n;
        float result = 1 / (a_poss * b_poss);
        System.out.printf("%.1f",result);
    }
}
