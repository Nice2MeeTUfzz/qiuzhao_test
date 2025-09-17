package NiuKe;

import java.util.*;
public class BISHI30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>>= 1;
        }
        System.out.println(count);
    }
}
