package 美团;

import java.util.Scanner;

// </https://codefun2000.com/p/P4646>
public class 无限循环 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int left = 0, right = 1;
            int count = 0;
            while (right < n) {
                if (arr[left] < arr[right]) {
                    right++;
                } else {
                    left = right;
                    right++;
                }
            }
            System.out.println(right - left);
        }
    }
}
