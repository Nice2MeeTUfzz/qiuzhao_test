package 小米823_1;

import java.util.*;

/*
题目内容:
小明正在玩一个游戏:这个游戏他需要从左往右依次经过(n)座山，其中第(i)座山的高度为(h_i)。

在游戏开始之前，他需要装备耐久足够高的登山鞋才行。
假设小明装备的登山鞋的耐久度为(x)，那么如果存在一个(i 1<i<n), |h_{i+1}-h_i|>x，那么小明就无法攀爬下一座山，
也就是说，任意相邻的两座山的高度之差不能超过(x)。

游戏正式开始之前，他利用前面关卡获得经验值购买了(k)次操作，其中每一次操作都可以修改任意一座山的高度，并且可以将其修改为任意非负整数高度。
他想知道:自己装备的登山鞋的耐久度最低可以是多少?

输入描述:
第一行:一个正整数(T)，表示数据组数.
对于每一组数据: 第一行输入两个正整数(n)和(k)，分别表示山的数量和小明购买的操作次数。
第二行:输入(n)个整数(h_1,h_2,...,h_n)，表示山的高度.
(1 <= n <= 500),(1 <= k <= 50),(0 <= h_i <= 2 * 10^9 )
输出描述:
对于每一组数据，输出一行一个整数，表示小明经过若干次操作之后可以装备的登山鞋的最低耐久度。
 */
public class BISHI2 {

    private static boolean isPossible(int[] h, int n, int k, int x) {
        int[] temp = Arrays.copyOf(h, n);
        int modifications = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(temp[i] - temp[i - 1]);
            if (diff > x) {
                modifications++;
                if (modifications > k) {
                    return false;
                }

                if (temp[i] > temp[i - 1]) {
                    temp[i] = temp[i - 1] + x;
                }else {
                    temp[i] = Math.max(0,temp[i - 1] - x);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] high_list = new int[n];
            // 将山的高度保存入high_list
            for (int i = 0; i < n; i++) {
                high_list[i] = sc.nextInt();
            }

            if (n <= 1) {
                System.out.println(0);
                continue;
            }

            int left = 0;
            int right = 2000000000;

            int answer = right;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossible(high_list, n, k, mid)) {
                    answer = mid;
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            System.out.println(answer);
        }
    }
}
