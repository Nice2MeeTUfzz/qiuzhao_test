package 美团0906;
/*
题目内容
小美有一个长度为n的数组a。你可以将a任意重排。定义一个长度为n的数组b，
其中b_i=MEX(a_1,a_2,...,a_i)。你需要最大化数组b中的元素之和。
你需要输出最大的元素和，以及一个可能的α的重排方案。
【名词解释】
MEX：整数数组的MEX定义为没有出现在数组中的最小非负整数。例如MEX{1，2，3}=0、MEX{0,2,5}=1。
输入描述
第一行输入一个整数n(1≤n≤2·10)，表示数组a的长度
第二行输入n个整数a1,@2,.,@n(0≤a≤10°)，表示数组a的元素。
输出描述
第一行输出一个整数，表示b的元素和。
第二行输出n个整数，表示重排后的a。
如果存在多个解决方案，您可以输出任意一个，系统会自动判定是否正确。注意，自测运行功能
可能因此返回错误结果，请自行检查等案正确性。
 */

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = MEX(a, i);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += res[i];
        }
        System.out.println(sum);
        printArray(a);
    }

    public static int MEX(int[] a, int end) {
        int res = 0;
        for (int i = 0; i <= end; i++) {
            if (a[i] == i) {
                res = a[i] + 1;
            }
        }
        return res;
    }
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
