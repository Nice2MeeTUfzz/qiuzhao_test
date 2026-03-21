package 小米;
// <https://codefun2000.com/p/P3739>
import java.util.Scanner;

public class 火车出站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 模型从左进，从左出是原进站口出1，右出是出站口2
        int left = 1, right = 0;
        int maxEntered = 0;
        int ans = 0;
        boolean[] exited = new boolean[n + 1];

        for (int x : arr) {
            if (x > maxEntered) {
                ans++;
                exited[x] = true;
                maxEntered = x;

                while(left <= maxEntered && exited[left]) left++;
                right = maxEntered;
                while (right >=1 && exited[right]) right--;
            }else {
                if(x == right){
                    exited[x] = true;
                    while (right >=1 && exited[right]) right--;
                    while(left <= maxEntered && exited[left]) left++;
                } else if (x == left) {
                    ans++;
                    exited[x] = true;
                    while (right >=1 && exited[right]) right--;
                    while(left <= maxEntered && exited[left]) left++;
                }else {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}
