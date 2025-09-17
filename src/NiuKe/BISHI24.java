package NiuKe;

import java.util.*;

public class BISHI24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Long, Long> counts = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            Long diff = (long) a - i;
            counts.put(diff, counts.getOrDefault(diff, 0L) + 1);
        }

        long sum = 0L;
        for (long l : counts.values()) {
            if (l > 1) {
                sum += l * (l - 1) / 2;
            }
        }
        System.out.println(sum);
    }
}
