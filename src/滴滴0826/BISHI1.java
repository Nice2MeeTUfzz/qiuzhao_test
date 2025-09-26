package 滴滴0826;

import java.util.*;

/**
 * <a href="https://codefun2000.com/p/P3476">...</a>
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long a1 = sc.nextLong();
            TreeMap<Long,Long> map = new TreeMap<>();
            for (int i = 0; i < n-1; i++) {
                long a = sc.nextLong();
                map.put(a,map.getOrDefault(a,0L)+1);
            }
            int cnt = 0;
            while (a1 <= map.lastKey()) {
                long maxVal = map.lastKey();
                a1 += maxVal / 2;
                decrease(map, maxVal);
                increase(map, maxVal - maxVal / 2);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    private static void increase(TreeMap<Long, Long> map, long key) {
        map.put(key,map.getOrDefault(key,0L)+1);
    }

    private static void decrease(TreeMap<Long, Long> map, long key) {
        if (map.get(key) == 1) {
            map.remove(key);
        }else{
            map.put(key, map.getOrDefault(key,0L)-1);
        }
    }
}
