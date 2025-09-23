package 小红书0907;
/*
题目内容
小红是小红书的用户行为分析师。平台将每次用户行为映射为一个正整数权重序列
{a1,a2,...,an},以便后续关联推荐时提取关键"红色"行为
为了保证标记的行为具有足够的共性，必须选出的所有"红色"行为权重的最大公约数大于1;
同时，为了避免相邻行为产生冗余，所选下标不得相邻
现给定用户的一次行为序列，求最多可以染成红色的行为数量
[名词解释]
最大公约数:指一组整数共有约数中最大的一个
例如，12、18和30的公约数有1,2,3,6,其中最大的约数是6,因此 gcd(12,18,30)=6
输入描述
在一行上输入一个整数n (1 ≤ n ≤ 10^5）,表示行为序列长度
在第二行输入n个整数a1,a2,...,an(1 ≤ a_i ≤ 100),表示每次行为的权重值
输出描述
在一行上输出一个整数，表示最多可染红的行为数量
 */

import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> ps = primesUpto(100);
        int ans = 0;
        for (int p : ps) {
            int pre2 = 0, pre1 = 0;
            for (int x : arr) {
                int b = (x % p == 0) ? 1 : 0;
                int cur = Math.max(pre1, pre2 + b);
                pre2 = pre1;
                pre1 = cur;
            }
            ans = Math.max(ans, pre1);
        }
        System.out.println(ans);
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static List<Integer> primesUpto(int m) {
        boolean[] isP = new boolean[m + 1];
        Arrays.fill(isP, true);
        isP[0] = false;
        isP[1] = false;
        for (int i = 2; i * i <= m; i++) {
            if (isP[i]) {
                for (int j = i * i; j <= m; j += i) {
                    isP[j] = false;
                }
            }
        }
        List<Integer> ps = new ArrayList<>();
        for (int i = 2; i <= m; i++) {
            if (isP[i]) {
                ps.add(i);
            }
        }
        return ps;
    }
}
