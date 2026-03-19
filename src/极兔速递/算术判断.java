package 极兔速递;

import java.util.Scanner;

public class 算术判断 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double x = in.nextDouble();
        double res = 0.000;
        if (x < 5 && x >= 0) {
            res = x + 2.5;
        } else if (x < 10 && x >= 5) {
            res = 2 - 1.5 * (x - 3) * (x - 3);
        } else if (x < 20 && x >= 10) {
            res = x / 2 - 1.5;
        }
        System.out.printf("%.3f",res);
    }
}
