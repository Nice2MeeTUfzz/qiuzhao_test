package NiuKe;

import java.util.*;
public class BISHI32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int m = sc.nextInt();
        int first = sc.nextInt();
        for (int i = 1; i < m; i++) {
            sc.nextInt();
        }
        System.out.println(first);
    }
}
