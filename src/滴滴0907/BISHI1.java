package 滴滴0907;

/**
 * 题目内容
 * 小红接触到了一款城市建设的游戏。在这个游戏玩家需要建造很多的设施。其中一些设施可以提供电力，而另一些则会
 * 消耗电力。每种设施均只能建造至多一个。且建造设施还需要花费一定的资金。
 * 如果某一时刻剩余电量（即所有发电设施产生的电力减去其他设施消耗的电力）恰好为1，则可以获得《高手电量》这一
 * 稀有成就。小红现在希望获得这一成就，请你帮他计算，如何才能在花费最少资金的情况下达成这一成就。
 * <p>
 * 输入描述
 * 输入的第一行包含一个数n(1<=n<=3000），表示小红可以建造n种不同的设施。
 * 接下来的n行，每行包括两个整数a_i,b_i
 * 表示建造第i种设施可以带来a_i的电力(如果a_i<0则表示消耗|a_i|的电力)，但需花费b_i的金额建造
 * 数据保证所有输入均为整数，|a_i|<3000，1<=b_i<=10^4，且a_i之和的绝对值不超过6000
 * <p>
 * 输出描述
 * 如果无法做到剩余电量为1，则输出一1
 * 如果可以，则输出所需花费的最小资金。
 */

import java.time.OffsetDateTime;
import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> allNode = new ArrayList<>();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Node node = new Node(a, b);
            allNode.add(node);
        }


        //动态规划
        int offset = 6000;
        int MAX_VALUE = 12000;
        int[] dp = new int[MAX_VALUE + 1];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);
        dp[offset] = 0;
        for (Node node : allNode) {
            int a = node.a;
            int b = node.b;
            for (int i = MAX_VALUE; i >= 0; i--) {
                if (dp[i] == INF) {
                    continue;
                }
                int currentPower = i - offset;
                int newPower = currentPower + a;
                int newIdx = newPower + offset;

                if (newIdx < 0 || newIdx > MAX_VALUE) {
                    continue;
                }
                dp[newIdx] = Math.min(dp[newIdx], dp[i] + b);
            }
        }
        int targetIdx = offset + 1;
        if (dp[targetIdx] == INF) {
            System.out.println(-1);
        }else {
            System.out.println(dp[targetIdx]);
        }
    }
}

class Node {
    int a;
    int b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
