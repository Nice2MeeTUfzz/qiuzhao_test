package 宇信科技1014;

import java.util.*;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int ls = 0;
            int sumWin = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'W') {
                    ls++;
                    if (ls >= 3) {
                        sumWin += k;
                    }else {
                        sumWin++;
                    }
                } else if (s.charAt(i) == 'L') {
                    ls = 0;
                    sumWin--;
                }
            }
            System.out.println(sumWin);
        }
    }
}
