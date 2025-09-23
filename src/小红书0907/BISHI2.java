package 小红书0907;
/*
题目内容
在小红书App首页的两列Plog中，小红薯独爱第一列
她将第一列每条Plog的点赞状态从上到下用一个二进制字符串s=(s1，s2,...,sn)表示，其中:
字符si= 1 表示用户已点赞第i条Plog
字符si= O 表示用户未点赞第i条Plog
小红薯定义一轮点赞行为如下:
选择索引对1 <= l <= r ≤ n;
从第l条Plog开始，到第r条Plog结束，进行一次重复点赞行为。
这会使得原本未点赞的Plog变为已点赞，原本已点赞的Plog变为未点赞
小红薯希望使得这一列Plog的点赞状态调整为一个回文串，即第一条和最后一条Plog的点赞状
态相同，第二条和倒数第二条Plog的点赞状态相同，以此类推。
请计算她最少需要进行的点赞行为轮数。
输入描述
每个测试文件均包含多组测试数据。第一行输入一个整数T（1≤T≤10)代表数据组数，每组
测试数据描述如下：
第一行输入一个整数n(1≤n<2*10°)，表示Plog数量；
第二行输入一个长度为n、由字符'0和'1'构成的字符串。，表示点赞状态。
除此之外，保证单个测试文件的n之和不超过2*10。
输出描述
对于每一组测试数据，新起一行，输出一个整数，代表使字符串s成为回文串所需的最少点赞行为轮数。
 */

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // Plog数量
            int n = sc.nextInt();
            String s = sc.next();
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < n / 2; i++) {
                int j = n-1-i;
                if (s.charAt(i) != s.charAt(j)) {
                    diff.add(i);
                }
            }
            if (diff.isEmpty()) {
                System.out.println(0);
                continue;
            }
            // 判断diff中连续的元素视为一个元素段，判断有多少个连续段
            int res = 1;
            for (int i = 1; i < diff.size(); i++) {
                if (diff.get(i) != diff.get(i - 1) + 1) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static boolean isHuiWen(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static char[] change(char[] arr, int start, int end) {
        if (start >= 0 && start <= end && end <= arr.length) {
            for (int i = start; i <= end; i++) {
                arr[i] = arr[i] == '1' ? '0' : '1';
            }
        }
        return arr;
    }
}
