package 恒生电子;

import java.util.*;

public class 第二题 {
    public static void main(String[] args) {
        int MAX_VAL = 100000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int maxVal  = 0;

        for (int i = 0; i < n - 1; i++) {
            maxVal = arr[i][2];
        }

        int curmax = 0;
        for (int i = 0; i < n - 1; i++) {
            curmax = Math.max(curmax, arr[i][2]);
        }
        maxVal += (n - 2) * curmax;

        curmax = 0;

        for (int i = 1; i < n - 1; i++) {
            curmax = Math.max(curmax, arr[i][2]);
        }

        maxVal += (n - 3) * curmax;

        System.out.println(maxVal);
    }
}
