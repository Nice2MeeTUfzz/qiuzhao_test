package 美团;

import java.util.*;
public class 最小公倍数题草稿 {
    private static int MOD = 1000000007;
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }
}
