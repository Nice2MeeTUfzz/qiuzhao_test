package 小米;
// <https://codefun2000.com/p/P3603>
import java.util.*;

public class 小明卖鞋 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p =  sc.nextInt();
        int q = sc.nextInt();
        int res = 0;
        Map<Integer, Integer>[][] showCounts = new HashMap[15][2];
        // 尺码范围35-49
        // 每个尺码对应两个Map，maps[sizeIndex][0]是左，maps[sizeIndex][1]是右
        // Map的key是颜色，value是颜色的数量
        for(int i = 0; i < 15; i++){
            showCounts[i][0] = new  HashMap<>();
            showCounts[i][1] = new  HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            int side =  sc.nextInt();
            int size = sc.nextInt();
            int color = sc.nextInt();
            int sizeIndex = size - 35;
            Map<Integer, Integer> currentMap = showCounts[sizeIndex][side];
            currentMap.put(color, currentMap.getOrDefault(color, 0) + 1);
        }

        long totalProfit = 0;
        for(int i = 0;i<15;i++){
            Map<Integer,Integer> leftMap = showCounts[i][0];
            Map<Integer,Integer> rightMap = showCounts[i][1];

            long remLeftTotal = 0;
            long remRightTotal = 0;
            Set<Integer> allColors = new HashSet<>(leftMap.keySet());
            allColors.addAll(rightMap.keySet());

            for(int color : allColors){
                int leftNum = leftMap.getOrDefault(color, 0);
                int rightNum = rightMap.getOrDefault(color, 0);

                int sameColorPairs = Math.min(leftNum, rightNum);
                totalProfit += (long) sameColorPairs * p;

                remRightTotal += leftNum - sameColorPairs;
                remLeftTotal += rightNum - sameColorPairs;
            }
            long diffColorPairs = Math.min(remLeftTotal, remRightTotal);
            totalProfit += diffColorPairs * q;
        }
        System.out.println(totalProfit);
    }

}