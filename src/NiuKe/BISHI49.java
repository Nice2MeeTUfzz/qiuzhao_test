package NiuKe;

import java.util.*;
public class BISHI49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];

        long totalTime = 0;
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLong();
            totalTime += a[i];
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long saveTime = 0;

        for (int i = n - 1; i >= 0; i--) {
            if ((i + 1) % k == 0 && !pq.isEmpty()) {
                saveTime += pq.poll();
            }
            pq.add(a[i]);
        }
        System.out.println(totalTime - saveTime);
    }
}
