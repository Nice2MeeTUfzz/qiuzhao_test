package 得物914;
/*
得物-2026届秋招0913
给你一个长度为n的数组A和一个长度为m的数组B,以及一个模数mod,你需要从数组A里选取一个数x,从数组B中选取一个数y
使得(x+y)%mod的值是所有选取方式中最小的,输出这个最小值即可。
输入描述：
第一行三个整数n,m，mod，分别表示A数组的长度、B数组的长度以及模数。
第二行n个整数，第i个表示A数组中第i个数的大小。
第三行m个整数，第i个表示B数组中第i个数的大小。
1<=n,m<=100000
1<=A[i], B[i],mod<= 10^18
输出描述：
一个整数v，表示求得的最小值。
样例输入：
4 5 1 0
2 3 4 5
1 2 3 4 6
样例输出：
0
 */

import java.util.*;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mod = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int i1 = (a[i] + b[j]) % mod;
                if (i1 < min) {
                    min = i1;
                }
            }
        }
        System.out.println(min);
    }
}
