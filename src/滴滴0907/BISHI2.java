package 滴滴0907;

/**
 * <a href="https://codefun2000.com/p/P3612">...</a>
 */


import java.util.*;

public class BISHI2 {
    // 效率极慢，会超时
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while (T-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = sc.nextInt();
//            }
//
//            Arrays.sort(a);
//
//            while (m-- > 0) {
//                int idxMax = a.length - 1;
//                int idxMin = 0;
//                a[idxMax] -= 1;
//                Arrays.sort(a);
//                a[idxMin] += 1;
//                Arrays.sort(a);
//            }
//            System.out.println(a[a.length - 1] - a[0]);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            TreeMap<Integer,Integer> countMap = new TreeMap<>();
            for (int num : a) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            while (m-- > 0) {
                int maxVal = countMap.lastKey();
                int minVal = countMap.firstKey();
                if (maxVal - minVal <= 1) {
                    break;
                }

                decrease(countMap, maxVal);
                increase(countMap, maxVal - 1);

                decrease(countMap, minVal);
                increase(countMap, minVal + 1);

            }
            System.out.println(countMap.lastKey() - countMap.firstKey());
        }
    }

    private static void decrease(TreeMap<Integer, Integer> map, int key) {
        int cnt = map.get(key);
        if (cnt == 1) {
            map.remove(key);
        }else {
            map.put(key, cnt - 1);
        }
    }

    private static void increase(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
