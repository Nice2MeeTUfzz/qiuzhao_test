package 美团;

import java.util.Arrays;
import java.util.Scanner;

// https://codefun2000.com/p/P4674
// 3
// 3 1 1 3
// 5 1 7
// 1 1 1 5
// 9
// 1 0 1 10
// 3

public class 风不吹雨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        while (T-- > 0) {
            int n =  sc.nextInt();
            int a =  sc.nextInt();
            int b = sc.nextInt();
            int k =  sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            for(int i = n-1; i >= 0; i--){
                if (a > 0 && b > 0) {
                    count += (arr[i] / 2 - k);
                    a--;
                    b--;
                } else if (a > 0 && b == 0) {
                    count += (arr[i] / 2);
                    a--;
                } else if (a == 0 && b > 0) {
                    count += (arr[i] - k);
                    b--;
                }else{
                    count += arr[i];
                }
            }
            System.out.println(count);
        }
    }
}
