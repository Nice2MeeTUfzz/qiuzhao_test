package NiuKe;

import java.util.Scanner;

public class BISHI19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        re(str,11);
        System.out.println();
        re(str, 21);
    }

    private static void re(String str, int k) {
        int w = 0;
        int l = 0;
        for (char c : str.toCharArray()) {
            if (c == 'W') {
                w++;
            } else {
                l++;
            }
            if ((w >= k || l >= k) && Math.abs(w - l) >= 2) {
                System.out.println(w + ":" + l);
                w = 0;
                l = 0;
            }
        }
        System.out.println(w + ":" + l);
    }
}

