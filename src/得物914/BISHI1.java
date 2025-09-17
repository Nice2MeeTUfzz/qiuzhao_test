package 得物914;

import java.util.*;
/*
老胡是一个“探险家”,对探险家来说收获谜题获取宝物是他们的终极目标.这次老胡打算进入一个多层迷宫.
迷宫的构造如下:
1. 迷宫一共有n层，其中第1层有一个房间，第2层有两个房间，第3层有三个房间，..第n层有n个房间。
2. 对于每一层，所有房间都从第1列开始进行排列
3. 迷宫的入口固定位于第1层
4. 由于迷宫的特殊构造，老胡进入一个房间后，不允许回退到上一层的房间，也不允许走到左边的房间，只允许走到右边或者下面的房间
5. 迷宫最后一层的每个房间都有最终的出口，且最后一层的每个房间没有通往左边和右边房间的门。
通过考古探测仪，老胡已经提前知道了每个房间里面有多少个金币，他规划出了一条可以从入口走到出口且可以得到最多金币的路径。
现在他想请你编写一个程序，输出最多可以得到多少个金币？
输入描述：
第一行一个正整数n(n<100)，表示迷宫层数。接下来n行，第一行有1个正整数，表示第一层房间的金币数
第二行有2个正整数，分别表示第二层2个房间的金币数
...第n行有n个正整数，表示第n行n个小房间的金币数.
数据确保每个房间至少有一枚金币，且数量均不超过1000.
输出描述:
输出老胡最多可以得到的金币数量。
样例输入:
3
2
45
123
样例输出:
13
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] gold = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                gold[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = gold[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = gold[i - 1][j] + gold[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + gold[i][j];
                }
            }
        }

        int maxCoins = 0;
        for (int j = 1; j <= n; j++) {
            if(dp[n][j]>maxCoins){
                maxCoins = dp[n][j];
            }
        }
        System.out.println(maxCoins);
    }
}
