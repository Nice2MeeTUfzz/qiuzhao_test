package 美团823;
/*
题目内容:
小美有n个长方形，第i个长方形的两条边长分别为x_i,y_i;
小美拥有一个仅包含第一象限的平面直角坐标系;
小美希望将这n个长方形按顺序（可以旋转）放置在x轴上，不允许重叠，并且每个长方形放置后的高度不超过m，保
证max(min(x_i,y_i))<=m；
请问，在满足上述条件的前提下，小美最少需要占用x轴的长度是多少？
输入描述:
第一行输入两个整数n,m(1<=n<=2×10^5;1<=m<=10^9)，分别表示长方形的个数和允许的最大高度
接下来n行，每行输入两个整数x_i，y_i(1<=xi,yi<=10^9)，分别表示第i个长方形的两条边长
输出描述:
输出一个整数，表示在每个长方形高不超过m的情况下，所需占用的最短x轴长度
 */

import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int index = 0;
        int w = 0;
        while (n-- > 0) {
            if (y[index] <= m) {
                w += Math.min(y[index], x[index]);
            }if (y[index] > m) {
                w+= y[index];
            }
            index++;
        }
        System.out.println(w);
    }
}
