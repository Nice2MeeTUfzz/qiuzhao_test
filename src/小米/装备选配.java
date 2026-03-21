package 小米;

import java.util.*;

public class 装备选配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 仓库一共有N件装备
        int N = sc.nextInt();
        // 需要挑选其中的M件
        int M = sc.nextInt();

        long[][] items = new long[N][3];
        for (int i = 0; i < N; i++) {
            items[i][0] = sc.nextLong();
            items[i][1] = sc.nextLong();
            items[i][2] = sc.nextLong();
        }
        long maxTotalAbsSum = 0;
        // 枚举三个属性的符号组合
        for (int i = 0; i < 8; i++) {
            int s0 = ((i) & 1) == 1 ? 1 : -1;
            int s1 = ((i >> 1) & 1) == 1 ? 1 : -1;
            int s2 = ((i >> 2) & 1) == 1 ? 1 : -1;

            Long[] scores = new Long[N];
            for (int j = 0; j < N; j++) {
                scores[j] = s0 * items[j][0] + s1 * items[j][1] + s2 * items[j][2];
            }

            Arrays.sort(scores, Collections.reverseOrder());

            long currentSum = 0;
            for (int j = 0; j < M; j++) {
                currentSum += scores[j];
            }
            maxTotalAbsSum = Math.max(maxTotalAbsSum, currentSum);
        }
        System.out.println(maxTotalAbsSum);
    }
}
