package 宇信科技1004;

import java.util.Scanner;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = getSum((int) c);
            for (int j = 0; j < count-1; j++) {
                System.out.print(c);
            }
            System.out.println(c);
        }
    }

    private static int getSum(int count) {
        int sum = 0;
        while (count > 0) {
            sum += count % 10;
            count /= 10;
        }
        return sum;
    }
}
