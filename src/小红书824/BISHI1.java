package 小红书824;

import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List<Integer> primes = getPrimes();
        int maxResult = 0;
        for(int p : primes){
            List<Integer> validIndices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] % p==0) {
                    validIndices.add(i);
                }
            }
            int count = countNonAdjacent(validIndices);
            maxResult = Math.max(maxResult, count);
        }
        System.out.println(maxResult);
    }

    public static List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[101];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= 100; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = i * i; j <= 100; j += i) {
                isPrime[j] = false;
            }
        }
        return primes;
    }

    private static int countNonAdjacent(List<Integer> indices) {
        int count = 0;
        int lastIndex = -2;
        for(int idx : indices) {
            if (idx > lastIndex + 1) {
                count++;
                lastIndex = idx;
            }
        }
        return count;
    }
}
