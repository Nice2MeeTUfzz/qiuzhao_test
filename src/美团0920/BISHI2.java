package 美团0920;

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = sc.nextLong();//一个+ && 一个-
            long b = sc.nextLong();//同+ || 同-
            long c = sc.nextLong();// 一+ && 一-
            long cost = 0;
            if ((x > y && y > 0) || (x < y && x > 0)) {
                long c1 = a * Math.abs(x - y) + b * Math.min(x,y);
                long c2 = a * (x + y);
                cost += Math.min(c1, c2);
            } else if (x > 0 && y < 0) {
                long c1 = a * (x - y);
                long c2 = b * Math.abs(y) + a * (x - y);
                long c3 = b * Math.abs(x) + a * (x - y);
                long c4 = c * Math.abs(y) + a * (x + y);
                cost += Math.min(Math.min(Math.min(c1, c2), c3), c4);
            } else if (x < 0 && y > 0) {
                long c1 = a * (y - x);
                long c2 = b * Math.abs(x) + a * (y - x);
                long c3 = b * Math.abs(y) + a * (y - x);
                long c4 = c * Math.abs(x) + a * (x + y);
                cost += Math.min(Math.min(Math.min(c1, c2), c3), c4);
            } else if ((x > y && x < 0) || (y > x && y < 0)) {
                long c1 = b * Math.max(x, y) + a * Math.abs(x - y);
                long c2 = a * (Math.abs(x) + Math.abs(y));
                cost += Math.min(c1, c2);
            } else if (x == y) {
                long c1 = b * Math.abs(x);
                long c2 = a * Math.abs(x) * 2;
                cost += Math.min(c1, c2);
            }
            System.out.println(cost);
        }
    }
}
