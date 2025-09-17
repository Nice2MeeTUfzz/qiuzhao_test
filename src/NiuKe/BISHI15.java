package NiuKe;

import java.util.Scanner;

public class BISHI15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int kou = 0;
            int yukari = 0;
            char[][] board = new char[3][3];
            for (int j = 0; j < 3; j++) {
                String line = in.nextLine();
                board[j] = line.toCharArray();

                if (line == "o*o") {
                    yukari++;
                } else if (line == "*o*") {
                    kou++;
                }
            }
        }
    }
}
