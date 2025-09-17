package NiuKe;

import java.util.*;

public class BISHI34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            test(sc.nextInt());
        }
    }

    public static void test(int n) {
        if (n == 3 || n == 6 || n == 9 || (n >= 10 && n % 2 == 1)) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }
}
