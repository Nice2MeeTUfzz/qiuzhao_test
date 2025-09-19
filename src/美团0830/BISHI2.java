package 美团0830;

/*
题目内容
小美是一位数学爱好者，她想知道给定的有理数在k进制下是否为一个有限小数。
换句话说，她希望判断在基数为k的表示中，该分数的小数部分是否会在有限位后结束，而不是无限循环。
例如，1/2在十进制下装示为0.5，是有限小数;相比之下，1/3在十进制下表示为0.3,不是有限小数。
输入描述
第一行输入一个整数T(1<T≤10)，表示测试数据的组数。
接下来T行，每行输入三个整数p,q,k(1≤p,q≤10^18,2≤k≤10^18)，分别表示分子p、分母q和进制基数。
输出描述
对于每一组测试数据，输出一行结果，若在k进制下是有限小数，则输出yes；否则输出no。
 */

import java.util.*;
public class BISHI2 {
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // p/q
            long p = sc.nextLong();
            long q = sc.nextLong();
            long k = sc.nextLong();

            long g = gcd(p, q);
            q = q / g;

            while (q != 1) {
                long gcdKQ = gcd(k, q);
                if (gcdKQ == 1) {
                    break;
                }
                while(q%gcdKQ==0) {
                    q = q/gcdKQ;
                }
            }
            System.out.println(q == 1 ? "yes" : "no");
        }
    }
}
