package 滴滴0913;

import java.util.*;

/**
 * <a href="https://codefun2000.com/p/P3663">...</a>
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
