package NiuKe;

import java.math.BigInteger;
import java.util.*;
public class BISHI53 {
    static class Node {
        int l, r;
        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long L0 = sc.nextLong(), R0 = sc.nextLong();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr,(x,y)->{
            long X = 1L * x.l * x.r;
            long Y = 1L * y.l * y.r;
            if (X != Y) {
                return Long.compare(X, Y);
            }else {
                return Integer.compare(x.l, y.l);
            }
        });

        BigInteger product = BigInteger.valueOf(L0);
        BigInteger maxReward = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            BigInteger currentReward = product.divide(BigInteger.valueOf(arr[i].r));
            if (maxReward.compareTo(currentReward) < 0) {
                maxReward = currentReward;
            }
            product = product.multiply(BigInteger.valueOf(arr[i].l));
        }
        System.out.println(maxReward);
    }
}
