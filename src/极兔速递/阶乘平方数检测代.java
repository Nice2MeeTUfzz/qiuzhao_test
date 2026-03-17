package 极兔速递;

import java.util.Scanner;

public class 阶乘平方数检测代 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int res = 0;
//        int left = 1;
//        while (jc(left) + 1 <= n) {
//            left++;
//        }
//        long[] memo = new long[left + 1];
//        for (int x = 1; x <= left; x++) {
//            memo[x] = jc(x) + 1;
//        }
//
//
//        for (int x = 1; x < left / 2; x++) {
//            if (wq(memo[x])) {
//                res++;
//            }
//        }
//        System.out.println(res);

        long factorial = 1;
        for(int x = 1;x<=20;x++){
            factorial *= x;
            long target = factorial +1;
            if(target >n) break;

            if(wq(target)){
                res++;
            }
            if (x < 20 && Long.MAX_VALUE / (x + 1) < factorial) {
                break;
            }
        }
        System.out.println(res);
    }

    static long jc(int x) {
        int res = 1;
        for (int i = 1; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    static boolean wq(long x) {
        // 超时
//        if (x == 0 || x == 1) {
//            return true;
//        }
//        for (long i = 2; i <= x / 2; i++) {
//            if (x == i * i) {
//                return true;
//            }
//        }
//        return false;
        if (x < 0) return false;
        if(x == 0 || x == 1) return true;
        long root = (long) Math.round(Math.sqrt(x));
        return root * root == x;
    }
}
