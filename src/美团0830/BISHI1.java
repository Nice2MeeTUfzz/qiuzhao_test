package 美团0830;

import java.util.ArrayList;

/*
题目内容
小美有一个数字n，小美打算按照以下规则对n进行操作:
如果n是偶数，让n除以2;
否则，让n乘以3再加1。
小美想知道，在操作k次后，n会变成多少。
输入描述
输入一行两个整数n,k,(2<n<1018,0<k<1018）
输出描述
输出n操作k次后的结果。
 */
import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        while(k-- > 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 2 == 1) {
                n = n * 3 + 1;
            }
        }
        System.out.println(n);
    }
}
