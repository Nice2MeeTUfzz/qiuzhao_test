package NiuKe;

import java.util.*;
public class BISHI35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            test(sc);
        }
    }
    public static void test(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n % (m + 1) == 0) {
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }
}
