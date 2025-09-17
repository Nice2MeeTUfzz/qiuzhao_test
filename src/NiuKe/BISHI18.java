package NiuKe;

import java.util.Scanner;

public class BISHI18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = in.nextInt();
        }

        StringBuilder result = new StringBuilder();
        boolean isFirst = true;

        for (int i = 0; i <= n; i++) {
            int coefficient = a[i];
            int degree = n - i;
            if (coefficient == 0) {
                continue;
            }

            if (isFirst) {
                if (coefficient < 0) {
                    result.append('-');
                }
                isFirst = false;
            } else {
                if (coefficient < 0) {
                    result.append('-');
                } else {
                    result.append('+');
                }
            }

            int abscoefficient = Math.abs(coefficient);

            if(!(abscoefficient == 1 && degree >= 1)){
                result.append(abscoefficient);
            }
            if (degree > 0) {
                result.append('x');
                if (degree > 1) {
                    result.append("^").append(degree);
                }
            }
        }
        System.out.println(result);
    }
}
