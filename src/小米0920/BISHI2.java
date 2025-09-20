package 小米0920;

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ai[i] >= ai[j]) {
                    continue;
                }else {
                    for (int k = j + 1; k < n; k++) {
                        if (ai[j] >= ai[k]) {
                            continue;
                        }else {
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
