package NiuKe;

import java.util.*;

public class BISHI37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            long x1 = 0;
            long x2 = 0;
            boolean flag = true;
            for (char c : s.toCharArray()) {
                int d = c - '0';
                int a, b;
                if (d % 2 == 0) {
                    a = d / 2;
                    b = d / 2;
                } else {
                    if (flag) {
                        a = (d + 1) / 2;
                        b = (d - 1) / 2;
                    } else {
                        a = (d - 1) / 2;
                        b = (d + 1) / 2;
                    }
                    flag = !flag;
                }
                x1 = x1 * 10 + a;
                x2 = x2 * 10 + b;
            }
            System.out.println(x1 + " " + x2);
        }
    }
}
