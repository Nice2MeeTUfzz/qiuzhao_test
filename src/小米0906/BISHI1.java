package 小米0906;

import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        Map<Integer, List<Integer>[]> shoesByType = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int isLeft = sc.nextInt();
            int size = sc.nextInt();
            int color = sc.nextInt();
            if (!shoesByType.containsKey(size)) {
                shoesByType.put(size, new List[2]);
                shoesByType.get(size)[0] = new ArrayList<>();
                shoesByType.get(size)[1] = new ArrayList<>();
            }
            if (isLeft == 0) {
                shoesByType.get(size)[0].add(color);
            } else {
                shoesByType.get(size)[1].add(color);
            }
        }
        long totalProfit = 0;
        for (Map.Entry<Integer, List<Integer>[]> entry : shoesByType.entrySet()) {
            List<Integer> leftshoes = entry.getValue()[0];
            List<Integer> rightshoes = entry.getValue()[1];
            int maxPossiblePairs = Math.min(leftshoes.size(), rightshoes.size());
            if (maxPossiblePairs == 0) {
                continue;
            }
            Map<Integer, Integer> leftColorCount = new HashMap<>();
            for (int color : leftshoes) {
                leftColorCount.put(color, leftColorCount.getOrDefault(color, 0) + 1);
            }

            int sameColorPairs = 0;
            for (int color : rightshoes) {
                if (leftColorCount.getOrDefault(color, 0) > 0) {
                    sameColorPairs++;
                    leftColorCount.put(color, leftColorCount.getOrDefault(color, 0) - 1);
                }
            }
            int differentColorPairs = maxPossiblePairs - sameColorPairs;
            totalProfit += (long) differentColorPairs * q + (long) sameColorPairs * p;
        }
        System.out.println(totalProfit);
    }
}
