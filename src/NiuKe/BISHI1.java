package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < line; j++) {
            int num = in.nextInt();
            if (num == 1) {
                int x = in.nextInt();
                list.add(x);
                printArray(list);
            } else if (num == 2) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (num == 3) {
                int x = in.nextInt();
                System.out.print(list.get(x));
            } else if (num == 4) {
                int i = in.nextInt();
                int x = in.nextInt();
                list.add(i + 1, x);
            } else if (num == 5) {
                Collections.sort(list);
            } else if (num == 6) {
                list.sort(Collections.reverseOrder());
            } else if (num == 7) {
                System.out.print(list.size());
            } else if (num == 8) {
                printArray(list);
            }
        }
    }

    public static void printArray(ArrayList<Integer> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i) + " ";
        }
        System.out.print(str);
    }
}
