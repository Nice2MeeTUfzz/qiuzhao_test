package 滴滴0927;

import java.util.*;

/**
 * <a href="https://codefun2000.com/p/P3822">...</a>
 * 将问题转换，当有一个节点的子节点得到消息，那么在下一个时刻，这个节点的另一个子节点也会得到消息
 * 那么最长的时间，也就是节点的子节点数最多的节点传递消息的时间，也就是选择最多的子节点数量
 */
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] childCount = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int parent = sc.nextInt();
                childCount[parent]++;
            }
            int maxChild = 0;
            for (int i = 1; i <= n; i++) {
                if (childCount[i] > maxChild) {
                    maxChild = childCount[i];
                }
            }
            System.out.println(maxChild);
        }
    }
}
