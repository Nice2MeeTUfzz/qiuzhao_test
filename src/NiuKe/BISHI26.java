package NiuKe;

import java.util.*;

public class BISHI26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int diff = Math.abs(a - b);
        int c = 0;
        if (a < b) {
            c = a - diff;
        }else if (a == b) {
            c = a;
        } else if (a > b) {
            c = b - diff;
        }
        System.out.println(c);
    }
}
