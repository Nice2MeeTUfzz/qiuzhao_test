package 小米823_2;

import java.util.*;

/*
俄罗斯方块游戏问题
题目描述
相信大家都玩过俄罗斯方块，本题将提供一个新版供大家体验一一静止版俄罗斯方块。简单来说
1. 游戏为玩家提供一个高度无限，宽度为n的界面，并且具有一个初始状态，包含n列不可破坏的方块，每一列宽度为1，高度为a_i
2. 游戏开始后,会有m个矩形方块依次贴着着界面最左边从无限高处下落，每个方块宽wi，高hi
3. 和传统的俄罗斯方块游戏一样，一旦下落的矩形方块碰到任意方块，就会立即停止下落。
遗憾的是,正如游戏的名字一样，在这个过程中玩家无法进行对方块进行任何操作,但是游戏换了一个玩法.
请玩家回答游戏过程中每个下落的矩形方块在停止下落时底部的高度是多少。
输入描述
输入第一行包含一个正整数n(1≤n≤100000)，表示游戏界面宽度。第二行包含n个正整数ai(1≤aj≤10^9,aj<=
a[i+1)，表示游戏初始状态。第三行包含一个正整数m，表示游戏过程中下落的矩形方块个数。接下来m行，每行包含两个
数字w_j和hi(1≤wj≤n,1≤hj≤10^9)，中间用空格隔开，代表一个方块的宽和高。
输出描述
一共输出m行答案，代表每个方块底部所处的高度。
样例输入
5
1 2 3 6 6
4
1 1
3 1
1 1
4 3
 */
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> h = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            int wi = sc.nextInt();
            int hi = sc.nextInt();
            int max = getMax(h, wi);
            for (int i = 0; i < wi; i++) {
                h.set(i, max + hi);
            }
            System.out.println(h.get(wi-1)-hi);
        }
    }

    private static int getMax(ArrayList<Integer> h, int right) {
        int max = 0;
        for (int i = 0; i < right; i++) {
            if (h.get(i) > max) {
                max = h.get(i);
            }
        }
        return max;
    }
}
