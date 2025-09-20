package 美团823;
/*
题目内容
小美有一个最喜欢的小于 2^20 的非负整数x
我们称数组 a 是 美丽的 ,当且仅当其满足以下所有条件:
1. 数组 a 中的每个元素都小于 2^20
2. 数组 a 中 不包含 相同的数
3. 对于数组a中任意两个处在不同位置的数 α_i和 a_j,都满足 a_i & a_j = x，其中 & 为按位与运算。特别地，当数组长度为 1 时，也视为满足此条件.
现在小美想让你帮他找到一个最长的美丽数组。如果存在多个最长的美丽数组，您可以输出任意一个，系统会自动判定是否正确
注意，自测运行功能可能因此返回错误结果，请自行检查答案正确性。
输入描述:
每个测试文件均包含多组测试数据。一行输入一个整数 T(1 <T < 500) 代表数据组数，每组测试数据描述如下:
输入一行一个整数 x(0 < x < 2^20)，表示小美最喜欢的非负整数
输出描述:
对于每组测试数据，先输出一行一个整数 k(1 <= k <= 100)，表示最长的美丽数组的长度。
可以证明在本题的数据范围内，最长的美丽数组的长度不会超过 100
接下来，在第二行输出 k 个不同整数 a1,a2,...,a_k(0 <= a_i< 2^20)，表示你找到的最长美丽数组。
 */

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int x = sc.nextInt();
            List<Integer> zeroBits = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                if ((x & (1 << i)) == 0) {
                    zeroBits.add(i);
                }
            }
            int k = zeroBits.size() + 1;
            System.out.println(k);
            int[] res = new int[k];
            res[0] = x;
            for (int i = 1;i < k;i++) {
                int bitIndex = zeroBits.get(i);
                int result = x | (1 << bitIndex);
                res[i] = result;
            }
            for (int i = 0; i < k; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}
