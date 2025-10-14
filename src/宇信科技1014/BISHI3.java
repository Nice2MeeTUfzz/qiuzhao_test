package 宇信科技1014;

import java.util.*;

//
public class BISHI3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long A = sc.nextLong();
//        long B = sc.nextLong();
//        String a = transform(A);
//        String b = transform(B);
//        if (a.length() != b.length()) {
//            int maxLen = Math.max(a.length(), b.length());
//            if (a.length() < maxLen) {
//                int aLen = a.length();
//                StringBuilder sb = new StringBuilder(a);
//                while (aLen < maxLen) {
//                    sb.append('0');
//                    aLen++;
//                }
//                a = sb.toString();
//                System.out.println(a);
//            } else if (b.length() < maxLen) {
//                int bLen = b.length();
//                StringBuilder sb = new StringBuilder(b);
//                while (bLen < maxLen) {
//                    sb.append('0');
//                    bLen++;
//                }
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) == '0' && b.charAt(i) == '1') {
//                sum++;
//            } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
//                System.out.println(0);
//                break;
//            }
//        }
//        System.out.println(sum);
//    }
//
//    private static String transform(long num) {
//        StringBuilder sb = new StringBuilder();
//        while (num > 0) {
//            sb.append(num % 2);
//            num /= 2;
//        }
//        return sb.toString();
//    }

    static class IntPair {
        private final int x;
        private final int y;

        public IntPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("%d,%d", x, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        List<IntPair> validPairs = findValidPairs(A, B);
        printResults(validPairs);
    }

    public static List<IntPair> findValidPairs(int A, int B) {
        List<IntPair> resultPairs = new ArrayList<>();
        for (int x = 0; x <= B; x++) {
            if (!isSubsetOf(x, B)) {
                continue;
            }
            // if X ^ Y = A Then, Y = X ^ A
            int y = x ^ A;
            if (isValidY(x, y, B)) {
                resultPairs.add(new IntPair(x, y));
            }
        }
        return resultPairs;
    }

    // check whether a number is the binary subset of another number
    private static boolean isSubsetOf(int num, int superset) {
        return (num & ~superset) == 0;
    }

    private static boolean isValidY(int x, int y, int B) {
        return isSubsetOf(y, B) && (x | y) == B && x < y;
    }

    private static void printResults(List<IntPair> Pairs) {
        if (Pairs.isEmpty()) {
            System.out.println(0);
        }
        else {
            for (IntPair pair : Pairs) {
                System.out.println(pair);
            }
        }
    }
}
