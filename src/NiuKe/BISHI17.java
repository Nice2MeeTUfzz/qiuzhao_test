package NiuKe;

import java.util.Scanner;

public class BISHI17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int k = 0; k < n; k++) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();

            int[][] a = {{a1, a2}, {a2, a1}};
            int[][] b = {{b1, b2}, {b2, b1}};
            int win = 0;
            for (int[] alex : a) {
                for (int[] bob : b) {
                    int awin = 0;
                    int bwin = 0;

                    if (alex[0] > bob[0]) {
                        awin++;
                    } else if (alex[0] < bob[0]) {
                        bwin++;
                    }

                    if(alex[1]>bob[1]){
                        awin++;
                    } else if(alex[1]<bob[1]){
                        bwin++;
                    }
                    if(awin>bwin){
                        win++;
                    }
                }
            }

            System.out.println(win);
        }
    }
}
