package 滴滴0913;

import java.util.*;

/*
题目内容
小A是一个喜欢玩电子游戏的人。他今天接触到了一款名为FS的新游戏，在这个游戏中，有
一个无穷大的坐标网格地图，在这个游戏的夜间模式中，玩家需要建造若干照明塔来为地图照
明，具体地，小A随时可以在（a，b）处建造一个光照半径为r的照明塔，建造完成后所有满足
max(|x一a|，|y一b|）<=r的点(x,y)处的光照等级都会加1(请注意这里是切比
雪夫距离小于等于r而非欧几里得距离，初始时所有位置的光照等级均为0）。
小A现在希望达成FS游戏中的一项成就，叫做“灯火通明”。具体而言，玩家需要使某一空点处
（即该坐标处没有照明塔）的光照等级增加到至少L。
小A可以通过建造多个照明塔来达到这一目的。在当前模式下有n种照明塔可供建造，第i种
照明塔的光照半径为r_i，造价为v_i，且至多能建造a_i座。
小A想知道达成这一成就至少需要花费多少钱，或者判断在当前模式下是否无法达成这一成就。
清注意，照明塔只能放置于整数坐标，且一个坐标处至多只能放置一个照明塔。
输入描述
本题单个测试点包含多组测试数据，输入数据第一行为数据组数T(1<=T<=10+)。
每组的第一行包含两个整数n(1<=n<=10)和L(1<=L<=10²²)，表示小A可以
建造的照明塔的种类数和达成成就所需的光照等级。
接下来n行每行包含三个整数ri、u¡和a(1 <=r; <=n，1 <=ui<= 10²，1<=
a;<=10°），含义如上文所示。
数据保证对于单个测试数据，所有的和不会超过101°。测试点内所有测试数据n之和不
会超过2 x10²。
输出描述
如果小A可以在当前模式下达成《灯火通明》成就，则输出最小所需花费，否则输出一1。
请注意答案可能会超过32位有符号整形数所能表示的最大范围。
 */
public class BISHI2 {
    static class TowerType {
        int r;
        int v;
        long a;

        TowerType(int r, int v, long a) {
            this.r = r;
            this.v = v;
            this.a = a;
        }
    }

    static class BIT {
        int n;
        long[] t;

        BIT(int n) {
            this.n = n;
            t = new long[n + 1];
        }

        void add(int i, long v) {
            for (; i <= n; i += i & -i) {
                t[i] += v;
            }
        }

        long sum(int i) {
            long s = 0;
            for (; i > 0; i -= i & -i) {
                s += t[i];
            }
            return s;
        }
    }

    static long Scap(long r) {
        return 4L * r * r + 4L * r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // n为照明塔种类
            int n = sc.nextInt();
            // L为某一空点处光照等级增加L
            long L = sc.nextLong();
            int Rmax = 0;
            TowerType[] towerTypes = new TowerType[n];
            for (int i = 0; i < n; i++) {
                int r = sc.nextInt();
                int v = sc.nextInt();
                long a = sc.nextLong();
                towerTypes[i] = new TowerType(r, v, a);
                if (Rmax < v) {
                    Rmax = v;
                }
            }

            Arrays.sort(towerTypes, new Comparator<TowerType>() {
                @Override
                public int compare(TowerType o1, TowerType o2) {
                    if (o1.v != o2.v) {
                        return o1.v - o2.v;
                    }
                    return o1.r - o2.r;
                }
            });

            BIT bit = new BIT(Rmax);
            long need = L, ans = 0;
            for (TowerType tt : towerTypes) {
                if (need == 0) {
                    break;
                }
                long used = bit.sum(tt.r);
                long allow = Scap(tt.r) - used;
                if (allow < 0) {
                    continue;
                }
                long take = Math.min(tt.a, Math.min(allow, need));
                ans += take * tt.v;
                need -= take;
                bit.add(tt.r, take);
            }
        }
    }
}
