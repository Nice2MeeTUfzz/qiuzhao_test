package NiuKe;

import java.util.Scanner;

public class BISHI16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            int count = dayofyear(year, month, day);
            System.out.println(count);
        }
    }

    private static int dayofyear(int year, int month, int day) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] months_pre = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            for (int i = 0; i < month - 1; i++) {
                count += months_pre[i];
            }
        } else {
            for (int i = 0; i < month - 1; i++) {
                System.out.println(months[i]);
                count += months[i];
            }
        }
        count += day;
        return count;
    }
}
