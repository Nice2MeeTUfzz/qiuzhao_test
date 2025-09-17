package NiuKe;

import java.util.Scanner;

public class BISHI20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start_date = in.nextInt();
        int end_date = in.nextInt();

        int start_year = start_date / 10000;
        int end_year = end_date / 10000;
        int count = 0;

        for (int i = start_year; i <= end_year; i++) {
            String ystr = String.format("%04d", i);
            String revystr = new StringBuilder(ystr).reverse().toString();
            int m = Integer.parseInt(revystr.substring(0, 2));
            int d = Integer.parseInt(revystr.substring(2, 4));
            System.out.println("ystr : " + ystr + ": m : " + m + " d :" + d);
            if (isReallyDate(i, m, d)) {
                int date = Integer.parseInt(ystr + revystr);
                System.out.println("date:" + date);
                if (date >= start_date && date <= end_date) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isReallyDate(int year, int month, int day) {
        int[] ping_year = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] run_year = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month < 1 || month > 12 || day < 1) {
            return false;
        }
        System.out.println("month : " + month);
        if (isLeap(year)) {
            return day <= run_year[month];
        } else {
            return day <= ping_year[month];
        }
    }

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
