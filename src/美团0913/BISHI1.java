package 美团0913;
/*
第1题-按位异或运算
题目内容:
给定一个正整数n，请你构造一个长度为n的排列{a_1, a_2,... a_n},满足:对任意位置i(从1开始)，i XOR ai为奇数
XOR表示按位异或

输入描述:
每个测试文件均包含多组测试数据。第一行输入一个整数T(1 ≤ T ≤ 2×10^5)表示测试数据组数。
此后T行：每行输入一个整数 n（1 ≤ n ≤ 2×10^5)。除此之外，保证单个测试文件中所有 n 的和不超过2×10^5。

输出描述:
对每组测试数据，新起一行输出:
1. 若存在满足条件的排列，输出任意一个满足条件的排列，共n个整数，数据之间用一个空格隔开
2.若不存在满足条件的排列，输出单个整数-1
如果存在多个解决方案，您可以输出任意一个

测试样例:
#输入
2
1
2
#输出
-1
2 1

样例说明:
对于n=1，无论ai取1，均有1 XOR 1=0为偶数,因此无解，输出-1。
对于n=2，取排列{2,1}:1 XOR 2=3、2 XOR 1=3，均为奇数，合法。
 */

import java.util.*;

public class BISHI1 {
    private static void toString(int[] res) {
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] res = isPossible(n);
            toString(res);
        }
    }

    private static int[] isPossible(int n) {
        //奇数个数不可行
        if (n % 2 == 1) {
            int[] res = new int[1];
            res[0] = -1;
            return res;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < n; i += 2) {
            int temp = res[i];
            res[i] = res[i + 1];
            res[i + 1] = temp;
        }
        return res;
    }
}
