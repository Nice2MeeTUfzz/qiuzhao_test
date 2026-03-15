package 滴滴0308;

import java.util.*;

public class 方格世界 {
    // 会有outofsize问题
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] dirs = new int[m][3];
//        for(int i = 0;i<m;i++){
//            for(int j = 0;j<3;j++){
//                dirs[i][j] = sc.nextInt();
//            }
//        }
//
//        int[] res = new int[n];
//        Arrays.fill(res, 0);
//        for(int[] dir: dirs){
//            int left = dir[0];
//            int right = dir[1];
//            int val = dir[2];
//            for(int i = left-1;i<right;i++){
//                res[i] += val;
//            }
//        }
//        System.out.println(res);
//        HashSet<Integer> set = new HashSet<>();
//        for (int s : res) {
//            set.add(s);
//        }
//        System.out.println(set.size());
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Long, Long> diff = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long left = sc.nextLong();
            long right = sc.nextLong();
            int val = sc.nextInt();
            diff.put(left, diff.getOrDefault(left, 0L) + val);
            diff.put(right + 1, diff.getOrDefault(right + 1, 0L) - val);
        }

        long height = 0L;
        Set<Long> set = new HashSet<>();
        for(long i=1; i<=n;i++){
            height += diff.getOrDefault(i, 0L);
            set.add(height);
        }
        System.out.println(set.size());
    }
}
