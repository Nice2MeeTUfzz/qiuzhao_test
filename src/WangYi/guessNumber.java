package WangYi;
import java.util.Scanner;
public class guessNumber {
    public static void main(String[] args) {
        final int N = 304;
        int[] arr = new int[N];
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = arr[n];
        int l = 0;
        int r = 1004;

        for (int i = 1; i <= n; i++) {
            int x = arr[i];
            if (x < l || x > r) {
                System.out.println("Are you kidding me?");
            } else if (x < ans) {
                System.out.println("It's too small");
                l = x + 1;
            } else if (x > ans) {
                System.out.println("It's too large");
                r = x - 1;
            } else {
                System.out.println("It's ok");
                break;
            }
        }
        sc.close();
    }
}
