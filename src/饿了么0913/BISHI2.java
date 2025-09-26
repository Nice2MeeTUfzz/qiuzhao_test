package 饿了么0913;

import java.util.*;

/**
 * 题目内容
 * 给定三个整数a、b、c，你可以且必须恰好执行一次如下操作：
 * 选择一个整数m，并将a、b、c中恰好一个数乘以m。完成上述操作后，你可以对这三个数进行任意重排。请
 * 判断是否存在一种选择，使得最终得到的三个数可以重排成一个等比数列。
 * 输入描述
 * 每个测试文件均包含多组测试数据。
 * 第一行输入一个整数t(1<t<10）代表数组组数，每组测试数据描述如下：
 * ● 在一行上输入三个整数a,b,c(一10°<a,b,c<10°)。
 * 输出描述
 * 对于每一组测试数据，新起一行。若存在可行方案，输出YES；否则输出NO。
 */
public class BISHI2 {
    public static boolean isSquareNonneg(long x) {
        if (x < 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

    private static boolean checkMul(long x, long y, long z) {
        // x*m为中项
        if (x == 0) {
            if (y == 0 || z == 0) {
                return true;
            }
        } else {
            long q = y * z;
            long xx = x * x;
            if (xx != 0 && q % xx == 0) {
                long v = q / xx;
                if (isSquareNonneg(v)) {
                    return true;
                }
            }
        }
        // y为中项，y^2 = x*m*z
        if (x == 0 || z == 0) {
            if (y == 0) {
                return true;
            }
        }else {
            long q = x * z;
            long yy = y * y;
            if (q != 0 && yy % q == 0) {
                return true;
            }
        }
        if (x == 0 || y == 0) {
            if (z == 0) {
                return true;
            }
        }else {
            long q = x * y;
            long zz = z * z;
            if (q != 0 && zz % q == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean ok(long a, long b, long c) {
        return checkMul(a,b,c) || checkMul(b,a,c) || checkMul(c,a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            System.out.println(ok(a,b,c)? "YES" : "NO");
        }
    }
}
