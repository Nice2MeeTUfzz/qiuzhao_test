package NiuKe;

import java.util.*;
public class BISHI36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();

            long m = n % (l + r);
            if (m >= l) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
